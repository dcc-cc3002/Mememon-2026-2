package cl.uchile.dcc
package player

import scala.collection.mutable.ArrayBuffer
import cl.uchile.dcc.unit.GameUnit

/**
 * defines the player of the game, who can control a list of units
 * @param name dame of the player
 * @param units units controlled by the player, such as characters and enemies
 * */
class Player(val name: String) {
  /** list of units that a player can control, initially empty */
  private val units: ArrayBuffer[GameUnit] = ArrayBuffer()
  /** returns a list of the player's units */
  def getUnits: List[GameUnit] ={
    units.toList
  }
  /** adds an unit to player's list of GameUnits */
  def addUnit(unit: GameUnit): Unit = {
    if (!units.contains(unit)){
      units+= unit
    }
  }
  /** a player would be defeated if all of his character units have 0 hp or less
   * depending on how much damaged they've received*/
  def isDefeated: Boolean = units.forall(unit => unit.hp <= 0)
}
