package cl.uchile.dcc
package model.combat

import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable
import model.units.{UnitsCommon, Character, EnemiesContract}

/** Default implementation of the turn scheduler. */
class TurnScheduler extends TurnSchedulerContract {
  private val units: ArrayBuffer[UnitsCommon] = ArrayBuffer[UnitsCommon]()
  private val actionBars: mutable.Map[UnitsCommon, Int] = mutable.Map[UnitsCommon, Int]()
  override def unitsArrayBuffer: ArrayBuffer[UnitsCommon] = units
  override def actionBarsMap: mutable.Map[UnitsCommon, Int] = actionBars

  override def add(unit: UnitsCommon): ArrayBuffer[UnitsCommon] = {
    if (!units.contains(unit)) then {
      units += unit
      actionBars(unit) = 0
    }
    units
  }

  override def remove(unit: UnitsCommon): ArrayBuffer[UnitsCommon] = {
    units-=unit
    actionBars-=unit
    units
  }

  override def maxActionBarUnit(unit: UnitsCommon): Double = {
    unit.maxActionBar
  }

  override def reset(unit: UnitsCommon): mutable.Map[UnitsCommon, Int] = {
    if (actionBars.contains(unit)) then actionBars(unit) = 0
    actionBars
  }

  override def increaseActionBars(k: Int): mutable.Map[UnitsCommon, Int] = {
    if (k >= 0) then
      for ((key, value) <- actionBars) {
        actionBars(key) = value + k
      }
    actionBars
  }

  override def statusActionBar(unit: UnitsCommon): Boolean = {
    if actionBars.contains(unit) then
      val maximo: Double = maxActionBarUnit(unit)
      if actionBars(unit) >= maximo then true
      else false
    else false
  }

  private def excedent(unit: UnitsCommon): Double = {
    actionBars(unit) - maxActionBarUnit(unit)
  }

  override def completedUnits(): ArrayBuffer[UnitsCommon] = {
    val result = ArrayBuffer[UnitsCommon]()

    for unit <- actionBars.keys do
      if statusActionBar(unit) then
        var position = 0

        // Find the position where the new unit goes, keeping the list sorted from highest to lowest excess
        while (position < result.length && excedent(result(position)) >= excedent(unit)) {
          position+=1
        }

        result.insert(position, unit)

    result
  }

  override def currentTurn(): Option[UnitsCommon] = {
    val completed = completedUnits()
    if completed.isEmpty then None
    else Some(completed(0))
  }
}


