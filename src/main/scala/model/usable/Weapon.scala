package cl.uchile.dcc
package model.usable

import model.units.Character

/** Contract for weapons that characters can equip. */
trait Weapon extends usableCommon {
  /** Returns the attack points of the weapon. */
  def attack: Int
  /** Returns the weight of the weapon. */
  def weight: Int
  /** Returns the character that owns the weapon, or None if it has no owner. */
  def owner: Option[Character]
}

