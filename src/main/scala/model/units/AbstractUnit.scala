package cl.uchile.dcc
package model.units

import model.actions.{Source, Target}
import model.usable.{Potion, Weapon}

/** Base class that stores the properties shared by all units.
 *
 * @param name The name of the unit.
 * @param health The health points of the unit.
 * @param defense The defense points of the unit.
 * @param weight The weight of the unit.
 */
abstract class AbstractUnit(val name: String, val health: Int, val defense: Int, val weight: Int) extends UnitsCommon {
  override def attackTo(target: Target): Boolean =
    target.receivesAttack(this)

  override def moveTo(target: Target): Boolean =
    target.receivesMove(this)
  // Source: actions that fail unless a subclass allows them
  override def equipWeaponTo(target: Target, weapon: Weapon): Boolean = false
  override def consumePotionTo(target: Target, potion: Potion): Boolean = false
  override def thunderTo(target: Target): Boolean = false
  override def meteorTo(target: Target): Boolean = false
  override def healTo(target: Target): Boolean = false
  override def purifyTo(target: Target): Boolean = false

  // Target: actions every unit can receive
  override def receivesAttack(source: Source): Boolean = false
  override def receivesThunder(source: Source): Boolean = false

  // Target: actions that fail unless a subclass allows them
  override def receivesMove(source: Source): Boolean = false
  override def receivesMeteor(source: Source): Boolean = false
  override def receivesEquipWeapon(source: Source, weapon: Weapon): Boolean = false
  override def receivesConsumePotion(source: Source, potion: Potion): Boolean = false
  override def receivesHeal(source: Source): Boolean = false
  override def receivesPurify(source: Source): Boolean = false
}

