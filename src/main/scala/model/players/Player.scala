package cl.uchile.dcc
package model.players

import model.units.UnitsCommon

class Player(val units: List[UnitsCommon]) extends PlayerContract {
  override def defeated(): Boolean = units.forall(_.health <= 0)
}
