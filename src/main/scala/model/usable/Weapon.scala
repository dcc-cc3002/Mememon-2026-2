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
  /** Returns the magic attack points of the weapon (0 for common weapons). */
  def magicAttack: Int
  /** Changes the owner of the weapon.
   *
   * @param newOwner The new owner, or None to leave the weapon without owner.
   */
  def changeOwner(newOwner: Option[Character]): Unit
  /** Returns true if the character is allowed to equip this type of weapon.
   *
   * @param character The character that wants to equip the weapon.
   */
  def isEquippableBy(character: Character): Boolean
}

