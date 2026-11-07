package cl.uchile.dcc
package model.combat

import model.units.UnitsCommon

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/** Contract for the turn scheduler, which keeps track of the action bars of the units in combat. */
trait TurnSchedulerContract {
  /** Returns the units in the scheduler. */
  def unitsArrayBuffer: ArrayBuffer[UnitsCommon]
  /** Adds a unit to the scheduler with its action bar in 0. Does nothing if the unit is already there.
   *
   * @param unit The unit to add.
   * @return The units in the scheduler.
   */
  def add(unit: UnitsCommon): ArrayBuffer[UnitsCommon]
  /** Removes a unit and its action bar from the scheduler.
   *
   * @param unit The unit to remove.
   * @return The units in the scheduler.
   */
  def remove(unit: UnitsCommon): ArrayBuffer[UnitsCommon]
  /** Returns the maximum value of the action bar of a unit.
   *
   * @param unit The unit to check.
   */
  def maxActionBarUnit(unit: UnitsCommon): Double
  /** Returns the current action bar of each unit in the scheduler. */
  def actionBarsMap: mutable.Map[UnitsCommon, Int]
  /** Sets the action bar of a unit back to 0.
   *
   * @param unit The unit whose action bar is reset.
   * @return The action bars of the units.
   */
  def reset(unit: UnitsCommon): mutable.Map[UnitsCommon, Int]
  /** Increases the action bar of every unit at the same time. Negative amounts are ignored.
   *
   * @param k The amount to add to each action bar.
   * @return The action bars of the units.
   */
  def increaseActionBars(k: Int): mutable.Map[UnitsCommon, Int]
  /** Returns true if the unit is in the scheduler and has completed its action bar.
   *
   * @param unit The unit to check.
   */
  def statusActionBar(unit: UnitsCommon): Boolean
  /** Returns the units that completed their action bar, from highest to lowest excess. */
  def completedUnits(): ArrayBuffer[UnitsCommon]
  /** Returns the unit whose turn it is (the one with the highest excess), or None if no unit completed its bar. */
  def currentTurn(): Option[UnitsCommon]
}