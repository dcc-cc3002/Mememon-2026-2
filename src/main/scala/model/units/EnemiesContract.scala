package cl.uchile.dcc
package model.units

/** Contract for enemies, the units that attack without a weapon. */
trait EnemiesContract extends UnitsCommon {
  /** Returns the attack points of the enemy. */
  def attack: Int
}