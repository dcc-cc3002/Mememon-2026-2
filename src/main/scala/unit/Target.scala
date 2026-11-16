package cl.uchile.dcc
package unit

import cl.uchile.dcc.action.{Action, DrinkPotion, EquipWeapon, Healing, ItemAction, Meteorite, Move, Purify, Spells, Thunder}
import cl.uchile.dcc.unit.{Source, GameUnit}
import cl.uchile.dcc.map.Panel



/** Trait describing a unit capable of receiving actions */

trait Target {
  /** target receives an action by a source */
  def receiveAction(action: Action, source: Source): Unit
  /** we define the different effects of different actions on target */
  /** target can receive an attack from a source */
  def receiveAttack(source: Source): Unit = {

  }

  /** target can be a panel that receives a moving unit* */
  def receiveMove(source: Source): Unit
  /** target can consume a potion */
  def receivePotion(action: DrinkPotion, source: Source): Unit
  /** can be the target of different spells, such as Healing, Purifying, Thunder or Meteorite.
   *  the specific target of these can be defined as well */
  def receiveHealing(action: Healing, source: Source): Unit
  def receivePurifying(action: Purify, source: Source): Unit
  def receiveThunder(action: Thunder, source: Source): Unit
  def receiveMeteorite(action: Meteorite, source: Source): Unit

}
