package cl.uchile.dcc
package model.units

import model.usable.{Weapon, usableCommon}

/** Contract for characters, the units that can hold a weapon and an inventory. */
trait Character extends UnitsCommon {
  /** Returns the equipped weapon, or None if the character has no weapon. */
  def weapon: Option[Weapon]
  /** Returns the inventory of usable items of the character. */
  def utilities: List[usableCommon]

  /** Returns true if the character can equip a sword. */
  def canEquipSword: Boolean
  /** Returns true if the character can equip a dagger. */
  def canEquipDagger: Boolean
  /** Returns true if the character can equip a bow. */
  def canEquipBow: Boolean
  /** Returns true if the character can equip a wand. */
  def canEquipWand: Boolean
  /** Returns true if the character can equip a staff. */
  def canEquipStaff: Boolean

  /** Applies the effect of a healing potion. Returns true if it has an effect on this character. */
  def drinkHealingPotion(): Boolean
  /** Applies the effect of a fortitude potion. Returns true if it has an effect on this character. */
  def drinkFortitudePotion(): Boolean
  /** Applies the effect of a mana potion. Returns true if it has an effect on this character. */
  def drinkManaPotion(): Boolean
  /** Applies the effect of a magic strength potion. Returns true if it has an effect on this character. */
  def drinkMagicStrengthPotion(): Boolean
}








