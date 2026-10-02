package cl.uchile.dcc
package enemies

/**
 * Represents the enemies of the game
 * @param name name of the enemy
 * @param hp health points of the enemy
 * @param defense how much can they resist an attack
 * @param attack their ability to attack a character
 * @param weight the heavier they are, the longer they take to execute an action
 * */

class enemies (val name: String, var hp: Int, var defense: Int, val attack: Int, val weight: Int){

}
