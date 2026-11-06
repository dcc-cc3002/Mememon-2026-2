package cl.uchile.dcc
package model.units

import model.actions.{Source, Target}

/** Contract shared by every unit of the game (characters and enemies). */
trait UnitsCommon extends Source with Target {
  /** Returns the name of the unit. */
  def name: String
  /** Returns the health points of the unit. */
  def health: Int
  /** Returns the defense points of the unit. */
  def defense: Int
  /** Returns the weight of the unit. */
  def weight: Int
  /** Returns the maximum value of the action bar of the unit. */
  def maxActionBar: Double
}
