package cl.uchile.dcc
package model.panels

import model.actions.Source
import model.units.UnitsCommon
import model.usable.{Potion, Weapon}

/** Every panel created so far, used to find adjacent panels. */
var PanelsList: List[Panel] = Nil

/** A panel of the game map. Each new panel registers itself in PanelsList.
 *
 * A panel can only receive the Move and Meteor actions; every other action fails.
 *
 * @param x The x coordinate of the panel.
 * @param y The y coordinate of the panel.
 * @param initialUnits The units located in the panel at the start.
 */
class Panel(val x: Int, val y: Int, val initialUnits: List[UnitsCommon]) extends PanelContract {
  private var currentUnits: List[UnitsCommon] = initialUnits

  PanelsList = this :: PanelsList

  override def units: List[UnitsCommon] = currentUnits

  override def addUnit(unit: UnitsCommon): Unit =
    if !currentUnits.contains(unit) then
      currentUnits = currentUnits :+ unit

  override def removeUnit(unit: UnitsCommon): Unit =
    currentUnits = currentUnits.filterNot(_ == unit)
  
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

  // Target, a unit can only move here from an adjacent panel
  override def receivesMove(unit: UnitsCommon): Boolean =
    val origin = nearbyPanels().find(panel => panel.units.contains(unit))
    if (origin.isDefined) {
      origin.get.removeUnit(unit)
      addUnit(unit)
      true
    } 
    else {
      false
    }

  // Target, Meteor damages every unit in the panel
  override def receivesMeteor(source: Source): Boolean = {
    for (unit <- units) {
      unit.takeDamage(source.magicDamage)
    }
    true
  }

  // Target, actions a panel cannot receive
  override def receivesAttack(source: Source): Boolean = false
  override def receivesEquipWeapon(source: Source, weapon: Weapon): Boolean = false
  override def receivesConsumePotion(source: Source, potion: Potion): Boolean = false
  override def receivesThunder(source: Source): Boolean = false
  override def receivesHeal(source: Source): Boolean = false
  override def receivesPurify(source: Source): Boolean = false
}


