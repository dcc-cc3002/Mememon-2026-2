package cl.uchile.dcc
package characters.commoncharacters

import cl.uchile.dcc.characters.Character

/**
 * Represents the character class of Thief, which extends the Character trait
 * @param name name of the character
 * @param maxHp maximum health points of the character
 * @param hp current health points of the character
 * @param defense how much can they resist an attack
 * @param weight the heavier they are, the longer they take to execute an action
 */
class Thief (val name: String, val maxHp: Double, var hp: Double, var defense: Double, val weight: Double) extends Character{

}
