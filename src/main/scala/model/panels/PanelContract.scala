package cl.uchile.dcc
package model.panels

import model.units.UnitsCommon

trait PanelContract {
  def x: Int
  def y: Int
  def units: List[UnitsCommon]
  def nearbyPanels(): List[PanelContract]
}