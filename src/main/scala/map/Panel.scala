package cl.uchile.dcc
package map

import scala.collection.mutable.ArrayBuffer
import cl.uchile.dcc.unit.GameUnit

/**
 * Defines the map of the game
 * @param x x-coordinate of the map
 * @param y y-coordinate of the map
 *  
 */
class Panel(val x: Int, val y: Int) {
  /** list of units in the panel */
  private val units: ArrayBuffer[GameUnit] = ArrayBuffer()

  /** returns a list of units*/
  def getUnit: List[GameUnit] = units.toList
  /** add units to a panel */
  def addUnit(unit: GameUnit): Unit = {
    if (!units.contains(unit)) {
      units += unit
      unit.setPanel(this)
    }
  }
  /** list of nearby panels */
  private var nearPanels: ArrayBuffer[Panel] = ArrayBuffer()
  /** returns a list of near panels */
  def getNearPanels: List[Panel] = nearPanels.toList
  /**define adjacent panels of the map if they are separated by 1 value of x or y coordinate*/
  def isAdjacent(panel: Panel): Boolean = {
    math.abs(x - panel.x) + math.abs(y-panel.y) == 1
  }
  /** we define a function to add a panel adjacent to the current one */
  def addNeighbor(panel: Panel): Unit = {
    if(isAdjacent(panel) && !nearPanels.contains(panel)) {
      nearPanels += panel
    }
  }
}

