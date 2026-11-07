package cl.uchile.dcc
package model.usable

/** Contract for weapons with magic attack points. */
trait MagicWeapon extends Weapon {
  /** Returns the magic attack points of the weapon. */
  def magicAttack: Int
}