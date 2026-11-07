package cl.uchile.dcc
package model.units

import model.actions.{Source, Target}

/** Contract shared by every unit of the game (characters and enemies).
 *
 * Every unit can perform actions (Source) and receive them (Target).
 */trait UnitsCommon extends Source with Target {
  /** Returns the name of the unit. */
  def name: String
  /** Returns the maximum health points of the unit. */
  def maxHealth: Int
  /** Returns the current health points of the unit. */
  def health: Int
  /** Returns the current defense points of the unit. */
  def defense: Int
  /** Returns the weight of the unit. */
  def weight: Int
  /** Returns the maximum value of the action bar of the unit. */
  def maxActionBar: Double

  /** Reduces the health of the unit, without going below 0.
   *
   * @param amount The health points to remove. Negative amounts are ignored.
   */
  def takeDamage(amount: Int): Unit
}
