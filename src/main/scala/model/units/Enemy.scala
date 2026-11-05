package cl.uchile.dcc
package model.units

/** An enemy of the game.
 *
 * Its action bar maximum is its weight.
 *
 * @param name The name of the unit.
 * @param health The health points of the unit.
 * @param attack The attack points of the enemy.
 * @param defense The defense points of the unit.
 * @param weight The weight of the unit.
 */
class Enemy(name: String, health: Int, val attack: Int, defense: Int, weight: Int) extends AbstractUnit(name, health, defense, weight) with EnemiesContract {
  override def maxActionBar: Double = weight
}
