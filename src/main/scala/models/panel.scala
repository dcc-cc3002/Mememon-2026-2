package cl.uchile.dcc
package models

class Panel(val x: Int, val y: Int) {
  var units: List[AbsCharacter] = List()

  var adjacentPanels: List[Panel] = List()

  def addAdjacent(panel: Panel): Unit = {
    if (!adjacentPanels.contains(panel)) {
      adjacentPanels = panel :: adjacentPanels
    }
  }

  def isAdjacentTo(other: Panel): Boolean = {
    adjacentPanels.contains(other)
  }
}