package cl.uchile.dcc
package model.combat

import model.units.UnitsCommon

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

trait TurnSchedulerContract {
  def unitsArrayBuffer: ArrayBuffer[UnitsCommon]
  def add(unit: UnitsCommon): ArrayBuffer[UnitsCommon]
  def remove(unit: UnitsCommon): ArrayBuffer[UnitsCommon]
  def maxActionBarUnit(unit: UnitsCommon): Double
  def actionBarsMap: mutable.Map[UnitsCommon, Int]
  def reset(unit: UnitsCommon): mutable.Map[UnitsCommon, Int]
  def increaseActionBars(k: Int): mutable.Map[UnitsCommon, Int]
  def statusActionBar(unit: UnitsCommon): Boolean
  def completedUnits(): ArrayBuffer[UnitsCommon]
  def currentTurn(): Option[UnitsCommon]
}