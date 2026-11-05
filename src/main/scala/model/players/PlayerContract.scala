package cl.uchile.dcc
package model.players

import model.units.UnitsCommon

/** Contract for the players that control units. */
trait PlayerContract {
  /** Returns the units of the player. */
  def units: List[UnitsCommon]
  /** Returns true if none of the units of the player is alive. */
  def defeated(): Boolean
}
