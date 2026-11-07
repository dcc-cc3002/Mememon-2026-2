package cl.uchile.dcc
package model.units

import model.usable.{Weapon, usableCommon}

import model.exceptions.InvalidActionException

/** Base class for characters that can use magic.
 *
 * Casting a spell spends mana only if the spell succeeds. A magic strength potion
 * increases the damage of the next spell by 50%.
 *
 * @param name The name of the unit.
 * @param initialHealth The maximum health points of the unit. The unit starts with this health.
 * @param initialDefense The defense points the unit starts with.
 * @param weight The weight of the unit.
 * @param initialWeapon The weapon the character starts with, if any.
 * @param initialUtilities The inventory of usable items the character starts with.
 * @param maxMana The maximum mana points of the character. The character starts with this mana.
 */
abstract class AbstractMagicCharacter(name: String, initialHealth: Int, initialDefense: Int, weight: Int, initialWeapon: Option[Weapon], initialUtilities: List[usableCommon],  
                                      maxMana: Int) extends AbstractCharacter(name, initialHealth, initialDefense, weight, initialWeapon, initialUtilities) with MagicCharacter {
  private var currentMana: Int = maxMana
  private var magicStrengthActive: Boolean = false

  override def mana: Int = currentMana
  
  override def magicDamage: Int = {
    val baseDamage = super.magicDamage
    if (magicStrengthActive) {
      (baseDamage * 1.5).toInt
    } 
    else {
      baseDamage
    }
  }

  /** Checks that the character has enough mana to cast a spell.
   *
   * @param cost The mana cost of the spell.
   * @param spellName The name of the spell, used in the error message.
   * @throws InvalidActionException if the character has less mana than the cost.
   */
  protected def checkEnoughMana(cost: Int, spellName: String): Unit = {
    if (currentMana < cost) {
      throw new InvalidActionException(s"$name is unable to cast $spellName since it only has $currentMana mana points and requireds $cost")
    }
  }

  /** Spends the mana of a spell that was cast successfully, and ends the magic strength effect.
   *
   * @param cost The mana cost of the spell.
   */
  protected def spendMana(cost: Int): Unit = {
    currentMana -= cost
    magicStrengthActive = false
  }

  override def drinkManaPotion(): Boolean = {
    val restored = (maxMana * 0.3).toInt
    val newMana = currentMana + restored
    if (newMana > maxMana) {
      currentMana = maxMana
    } 
    else {
      currentMana = newMana
    }
    true
  }

  override def drinkMagicStrengthPotion(): Boolean = {
    magicStrengthActive = true
    true
  }
  
}


