package cl.uchile.dcc
package controller

import model.actions.{ActionContract, Target}
import model.combat.{TurnScheduler, TurnSchedulerContract}
import model.units.UnitsCommon

/** Main controller of the game.
 *
 * It keeps the units in combat and the turn scheduler, decides which unit plays
 * each turn, and executes the actions of that unit. For now, the game is an
 * endless loop of turns.
 *
 */
class GameController {
  /** The amount (k) added to every action bar on each step of the turn cycle. */
  private val actionBarIncrease: Int = 10
  private val scheduler: TurnSchedulerContract = new TurnScheduler
  private var nowUnit: Option[UnitsCommon] = None
  private var turns: Int = 0

  /** Adds a unit to the combat, with its action bar in 0. Does nothing if it is already there.
   *
   * @param unit The unit to add.
   */
  def addUnit(unit: UnitsCommon): Unit =
    scheduler.add(unit)

  /** Removes a unit from the combat.
   *
   * @param unit The unit to remove.
   */
  def removeUnit(unit: UnitsCommon): Unit = {
    scheduler.remove(unit)
  }

  /** Returns the units in combat. */
  def units: List[UnitsCommon] =
    scheduler.unitsArrayBuffer.toList

  /** Returns the unit that is playing its turn, or None if no unit has the turn. */
  def currentUnit: Option[UnitsCommon] =
    nowUnit

  /** Returns the number of turns completed since the game started or was reset. */
  def turnCount: Int =
    turns

  /** Decides which unit plays the next turn.
   *
   * Increases the action bars of all units at the same time until at least one of them
   * completes its bar, and gives the turn to the unit with the highest excess.
   * If a unit already has the turn, it keeps it until it performs an action.
   *
   * @return The unit that plays the turn, or None if there are no units in combat.
   */
  def nextTurn(): Option[UnitsCommon] = {
    if (nowUnit.isEmpty && units.nonEmpty) {
      while (scheduler.currentTurn().isEmpty) {
        scheduler.increaseActionBars(actionBarIncrease)
      }
      nowUnit = scheduler.currentTurn()
    }
    nowUnit
  }

  /** Returns the actions a unit can perform.
   *
   * @param unit The unit whose actions are requested.
   */
  def availableActions(unit: UnitsCommon): List[ActionContract] =
    unit.actions

  /** Executes an action of the current unit on a target.
   *
   * If the action succeeds, the action bar of the unit is reset and the turn ends.
   * If it fails, the turn does not change.
   *
   * @param action The action to execute.
   * @param target The entity that receives the action.
   * @return True if the action was executed successfully, false otherwise.
   */
  def executeAction(action: ActionContract, target: Target): Boolean = {
    if (nowUnit.isDefined && nowUnit.get.doAction(action, target)) {
      scheduler.reset(nowUnit.get)
      nowUnit = None
      turns += 1
      true
    }
    else {
      false
    }
  }

  /** Resets the state of the game: every action bar goes back to 0, no unit has the turn,
   * and the turn count goes back to 0. The units stay in combat.
   */
  def resetGame(): Unit = {
    for (unit <- units) {
      scheduler.reset(unit)
    }
    nowUnit = None
    turns = 0
  }
}
