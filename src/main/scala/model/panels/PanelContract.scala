package cl.uchile.dcc
package model.panels

import model.actions.Target
import model.units.UnitsCommon

/** Contract for the panels (cells) of the game map. */
trait PanelContract extends Target {
  /** Returns the x coordinate of the panel. */
  def x: Int
  /** Returns the y coordinate of the panel. */
  def y: Int
  /** Returns the units currently located in the panel. */
  def units: List[UnitsCommon]
  /** Returns the panels adjacent to this one, at coordinates (x +- 1, y) and (x, y +- 1). */
  def nearbyPanels(): List[PanelContract]

  /** Places a unit in the panel. Does nothing if the unit is already there.
   *
   * @param unit The unit to place.
   */
  def addUnit(unit: UnitsCommon): Unit

  /** Removes a unit from the panel. Does nothing if the unit is not there.
   *
   * @param unit The unit to remove.
   */
  def removeUnit(unit: UnitsCommon): Unit
}