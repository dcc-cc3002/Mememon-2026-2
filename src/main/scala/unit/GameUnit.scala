package cl.uchile.dcc
package unit

import cl.uchile.dcc.map.Panel

/**
 * Here I will define the common characteristics
 * that the different units of the game share
 * such as common characters, magic characters and enemies
 *
 */

trait GameUnit {
  /** name of the unit */
  val name: String
  /** max health of the unit*/
  val maxHp: Double
  /** the heavier, the longer they take to act*/
  val weight: Double
  /**current health of the unit*/
  var hp: Double
  /**defense points of the unit*/
  var defense: Double
  /**location in a panel of the map. Unless it is implemented by a Player, it will be None*/
  var position: Option[Panel] = None
  /** the position of the unit in the map can be defined */
  def setPanel(panel: Panel): Unit = {
    position = Some(panel)
  }
  /** every unit will have an action bar based on their weight and weapon (if it's a character)*/
  def actionBarMax: Double
}
  
