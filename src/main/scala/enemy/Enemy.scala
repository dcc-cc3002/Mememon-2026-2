package cl.uchile.dcc
package enemy

import cl.uchile.dcc.unit.GameUnit

/**
 * Represents the enemies of the game
 * @param name name of the enemy
 * @param maxHp maximum health points of the enemy
 * @param hp current health points of the enemy
 * @param defense how much can they resist an attack
 * @param attack their ability to attack a character
 * @param weight the heavier they are, the longer they take to execute an action
  */

class Enemy (val name: String, val maxHp: Double, var hp: Double, var defense: Double, val weight: Double, val attack: Double) extends GameUnit {

  /** enemy's action bar depends solely on its weight */
  def actionBarMax: Double = weight
}
