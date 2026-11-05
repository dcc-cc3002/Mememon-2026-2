package cl.uchile.dcc
package model.units

import model.usable.{Weapon, usableCommon}

/** Contract for characters, the units that can hold a weapon and an inventory. */
trait Character extends UnitsCommon {
  /** Returns the equipped weapon, or None if the character has no weapon. */
  def weapon: Option[Weapon]
  /** Returns the inventory of usable items of the character. */
  def utilities: List[usableCommon]
}







