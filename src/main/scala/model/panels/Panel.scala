package cl.uchile.dcc
package model.panels

import model.units.UnitsCommon


var PanelsList: List[Panel] = Nil

class Panel(val x: Int, val y: Int, val units: List[UnitsCommon]) extends PanelContract {
  PanelsList = this :: PanelsList
  override def nearbyPanels(): List[Panel] = {
    var nearbyPanelsList: List[Panel] = Nil
    for (p <- PanelsList) {
      val xPanelsList: Int = p.x
      val yPanelsList: Int = p.y
      if Math.sqrt(Math.pow(xPanelsList - x, 2) + Math.pow(yPanelsList - y, 2)) == 1 then
        nearbyPanelsList = p :: nearbyPanelsList
    }
    nearbyPanelsList
  }
}


