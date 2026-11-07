package cl.uchile.dcc
package action

import cl.uchile.dcc.unit.{Source, Target}

/** This trait will be common for all the actions that a player can
 * do in the game, such as move around the map, attack, use a potion,
 * equip a weapon and cast spells
 *
 * Via double dispatch, relates to Target
 *
 * */

trait Action {
  /** name of the action */
  val name: String
  /** definition of doing an action over a target*/
  /** the execution will depend now on the target */
  def doAction(source: Source, target: Target): Unit = {
    target.receiveAction(this, source)
  }
}



