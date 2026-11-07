package cl.uchile.dcc
package model.players

import model.units.UnitsCommon

/** A player of the game.
 *
 * @param units The units controlled by the player.
 */
class Player(val units: List[UnitsCommon]) extends PlayerContract {
  override def defeated(): Boolean = units.forall(_.health <= 0)
}
