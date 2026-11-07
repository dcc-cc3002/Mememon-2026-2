package cl.uchile.dcc
package model.units

import model.actions.{ActionContract, ConsumePotion, EquipWeapon, Source, Target}

import model.usable.{Potion, Weapon, usableCommon}

/** Base class for all characters.
 *
 * Its action bar maximum is its weight plus half the weight of its weapon.
 * A character can only attack if it has a weapon, and it can equip weapons
 * and consume potions from its inventory, only on itself.
 * By default it cannot equip any weapon type; each subclass allows its own.
 *
 * @param name The name of the unit.
 * @param initialHealth The maximum health points of the unit. The unit starts with this health.
 * @param initialDefense The defense points the unit starts with.
 * @param weight The weight of the unit.
 * @param initialWeapon The weapon the character starts with, if any.
 * @param initialUtilities The inventory of usable items the character starts with.
 */
abstract class AbstractCharacter(name: String, initialHealth: Int, initialDefense: Int, weight: Int, val initialWeapon: Option[Weapon],
                                 val initialUtilities: List[usableCommon]) extends AbstractUnit(name, initialHealth, initialDefense, weight) with Character {
  private var currentWeapon: Option[Weapon] = initialWeapon
  private var inventory: List[usableCommon] = initialUtilities

  override def weapon: Option[Weapon] = currentWeapon
  override def utilities: List[usableCommon] = inventory

  override def attackDamage: Int = weapon.map(_.attack).getOrElse(0)
  override def magicDamage: Int = weapon.map(_.magicAttack).getOrElse(0)
  override def maxActionBar: Double = weight + 0.5 * weapon.map(_.weight).getOrElse(0)

  override def actions: List[ActionContract] =
    super.actions ++ List(new EquipWeapon("Equip weapon", Nil), new ConsumePotion("Consume potion", Nil))

  // Source, a character without a weapon cannot attack
  override def attackTo(target: Target): Boolean =
    weapon.isDefined && super.attackTo(target)

  // Source, equipping and consuming are only done on the character itself
  override def equipWeaponTo(target: Target, newWeapon: Weapon): Boolean =
    target == this && target.receivesEquipWeapon(this, newWeapon)

  override def consumePotionTo(target: Target, potion: Potion): Boolean =
    target == this && target.receivesConsumePotion(this, potion)

  // Target, actions only characters can receive
  override def receivesEquipWeapon(source: Source, newWeapon: Weapon): Boolean = {
    checkNotDefeated("Equip weapon")
    val isInInventory = inventory.contains(newWeapon)
    val isAllowed = newWeapon.isEquippableBy(this)
    if (isInInventory && isAllowed) {
      if (currentWeapon.isDefined) {
        currentWeapon.get.changeOwner(None)
      }
      newWeapon.changeOwner(Some(this))
      currentWeapon = Some(newWeapon)
      true
    }
    else {
      false
    }
  }

  // Target, the potion must be in the inventory, and it is removed once consumed
  override def receivesConsumePotion(source: Source, potion: Potion): Boolean = {
    checkNotDefeated("Consume potion")
    val isInInventory = inventory.contains(potion)
    if (isInInventory) {
      val hasEffect = potion.applyTo(this)
      if (hasEffect) {
        inventory = inventory.diff(List(potion))
        true
      }
      else {
        false
      }
    }
    else {
      false
    }
  }

  override def receivesHeal(source: Source): Boolean = {
    checkNotDefeated("Heal")
    restoreHealth((maxHealth * 0.2).toInt + source.magicDamage / 4)
    true
  }

  // Weapons this character can equip
  override def canEquipSword: Boolean = false

  override def canEquipDagger: Boolean = false

  override def canEquipBow: Boolean = false

  override def canEquipWand: Boolean = false

  override def canEquipStaff: Boolean = false

  // Potion effects
  override def drinkHealingPotion(): Boolean = {
    restoreHealth((maxHealth * 0.2).toInt)
    true
  }

  override def drinkFortitudePotion(): Boolean = {
    changeDefense((defense * 1.15).toInt)
    true
  }

  override def drinkManaPotion(): Boolean = false

  override def drinkMagicStrengthPotion(): Boolean = false
}

