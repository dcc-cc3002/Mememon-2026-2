package cl.uchile.dcc
package model.panels

import model.units.UnitsCommon

/** Contract for the panels (cells) of the game map. */
trait PanelContract {
  /** Returns the x coordinate of the panel. */
  def x: Int
  /** Returns the y coordinate of the panel. */
  def y: Int
  /** Returns the units located in the panel. */
  def units: List[UnitsCommon]
  /** Returns the panels adjacent to this one, at coordinates (x +- 1, y) and (x, y +- 1). */
  def nearbyPanels(): List[PanelContract]
}