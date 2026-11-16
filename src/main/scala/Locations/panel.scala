package cl.uchile.dcc
package Locations

import Exceptions.invalidInputException
import Source_target.{source, target}
import Units.{BlackWizard, WhiteWizard, abstractUnits, character, enemy, units}
//each panel keeps their neighbors, coordinates and some functions to be referenced if someone throws an attack that do area damage
class panel(val x: Int, val y: Int) extends target{
  def Name = "Panel"
  private var unitsList : List[units] = List.empty
  var North: Option[panel] = None
  var South: Option[panel] = None
  var East: Option[panel] = None
  var West: Option[panel] = None

  override def beConsumed(source: character): Unit = throw invalidInputException("A panel cannot be consumed")
    
  override def isAlive:Boolean =
    throw invalidInputException("A panel neither can be Alive nor Dead")

  override def receiveAttackFromCharacter(source: Units.character): Unit =
    throw invalidInputException("A panel cannot be attacked")

  override def receiveAttackFromEnemy(source: enemy): Unit =
    throw invalidInputException("A panel cannot be attacked")

  override def receiveHeal(source: WhiteWizard): Unit =
    throw invalidInputException("A panel cannot be healed")

  override def receivePurification(source: WhiteWizard): Unit =
    throw invalidInputException("A panel cannot be Purified")

  override def receiveThunder(source: BlackWizard): Unit =
    throw invalidInputException("A panel cannot receive Thunder")
  
  //implemented with pattern matching to avoid type errors
  override def receiveMeteorite(source: source): Unit = {
    source match{
      case s:BlackWizard =>
        for (units <- this.unitsList) units.receiveThunder(s)
        this.North match{
          case Some(neighbour) =>
            for (units <- neighbour.unitsList) units.receiveThunder(s)
          case None =>
        }
        this.South match{
          case Some(neighbour) =>
            for (units <- neighbour.unitsList) units.receiveThunder(s)
          case None =>
        }
        this.East match{
          case Some(neighbour) =>
            for (units <- neighbour.unitsList) units.receiveThunder(s)
          case None =>
        }
        this.West match{
          case Some(neighbour) =>
            for (units <- neighbour.unitsList) units.receiveThunder(s)
          case None =>
        }
      case _ =>
        throw invalidInputException("Cannot receive Meteorite from this Source")
    }
  }

  override def beSet(source: Units.character): Unit =
    throw invalidInputException("A panel cannot be a weapon")

  override def setNewPosition(source: abstractUnits): Unit =
    source.currentLocation match {
      case Some(curr) =>
        curr.North match{
          case Some(n) =>
            if this == n then source.currentLocation = Some(this)
          case None =>
        }
        curr.South match{
          case Some(s) =>
            if this == s then source.currentLocation = Some(this)
          case None =>
        }
        curr.East match{
          case Some(e) =>
            if this == e then source.currentLocation = Some(this)
          case None =>
        }
        curr.West match{
          case Some(w) =>
            if this == w then source.currentLocation = Some(this)
          case None =>
        }
      case None =>
    }
}