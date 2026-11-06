package cl.uchile.dcc
package model.panels

import model.actions.Source
import model.units.UnitsCommon
import model.usable.{Potion, Weapon}

/** Every panel created so far, used to find adjacent panels. */
var PanelsList: List[Panel] = Nil

/** A panel of the game map. Each new panel registers itself in PanelsList.
 *
 * @param x The x coordinate of the panel.
 * @param y The y coordinate of the panel.
 * @param units The units located in the panel.
 */
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
  // Target: actions a panel can receive 
  override def receivesMove(source: Source): Boolean = false
  override def receivesMeteor(source: Source): Boolean = false

  // Target: actions a panel cannot receive
  override def receivesAttack(source: Source): Boolean = false
  override def receivesEquipWeapon(source: Source, weapon: Weapon): Boolean = false
  override def receivesConsumePotion(source: Source, potion: Potion): Boolean = false
  override def receivesThunder(source: Source): Boolean = false
  override def receivesHeal(source: Source): Boolean = false
  override def receivesPurify(source: Source): Boolean = false
}


