package cl.uchile.dcc
package model.players

import model.units.UnitsCommon

trait PlayerContract {
  def units: List[UnitsCommon]
  def defeated(): Boolean
}
