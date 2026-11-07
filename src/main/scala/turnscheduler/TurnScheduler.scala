package cl.uchile.dcc
package turnscheduler

import cl.uchile.dcc.unit.GameUnit
import scala.collection.mutable.{ArrayBuffer, Map=>MutableMap}
import cl.uchile.dcc.characters.{Character, MagicCharacter}
import cl.uchile.dcc.enemy.Enemy

/**
 * Coordinates combat and action bar of the units in combat
 */
class TurnScheduler {
  private val units: ArrayBuffer[GameUnit] = ArrayBuffer()
  private val actionBar: MutableMap[GameUnit, Double] = MutableMap()

  /** adds a new combat unit to the scheduler with its action bar  */
  def addUnit(unit: GameUnit): Unit ={
    if(!units.contains(unit)){
      units += unit
      actionBar(unit)=0.0
    }
  }
  /**removes a combat unit from the scheduler and its action bar*/
  def removeUnit(unit: GameUnit): Unit = {
    units -= unit
    actionBar.remove(unit)
  }

  /**gets the maximum action bar of a combat unit*/
  private def maxActionBar(unit: GameUnit): Double = unit.actionBarMax

  /**gets the current action bar of a combat unit*/
  def getActionBar(unit: GameUnit): Option[Double] = {
    actionBar.get(unit)
  }

  /**resets action bar of a combat unit*/
  def resetActionBar(unit: GameUnit): Unit = {
    if(actionBar.contains(unit)){
      actionBar(unit)=0.0
    }
  }

  /**  increase the actionBar of all the units*/
  def increaseActionBar(amount: Double): Unit ={
    if(amount > 0.0) {
      units.foreach {
        unit => actionBar(unit) = actionBar(unit) + amount
      }
    }
  }


  /** checks if a unit has its action bar complete to the max*/
  private def isComplete(unit: GameUnit): Boolean = {
    actionBar.get(unit).exists(_>=maxActionBar(unit))
  }

  /** scheduler has to return units that completed their actionBar
   * on a higher to lower excedent after completing their actionBar */
  private def getReadyUnits: List[GameUnit] = {
    units
      .filter(unit => isComplete(unit))
      .sortBy(unit => maxActionBar(unit) - actionBar(unit))
      .toList
  }

  /**scheduler has to get the only Unit which turn is it*/
  /**since it has them in order based on their excent, the current turn will be
   * for the unit with the highest amount
   */
  def turnUnit: Option[GameUnit]={
    getReadyUnits.headOption
  }
}

