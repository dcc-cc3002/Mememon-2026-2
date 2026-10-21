package cl.uchile.dcc
package unit
/**
 * Here I will define the common characteristics
 * that the different units of the game share
 * such as common characters, magic characters and enemies
 */

trait Unit {
  val name: String /*name of the unit */
  val maxHp: Double /* max health of the unit*/
  val weight: Double /*the heavier, the longer they take to act*/
  var hp: Double /*current health of the unit*/
  var defense: Double /*defense points of the unit*/
}
