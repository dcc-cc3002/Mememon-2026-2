package cl.uchile.dcc
package model.units

import model.actions.Source

/** An enemy of the game.
 *
 * Its action bar maximum is its weight, and it attacks with its own attack points.
 * Enemies cannot cast spells, and they are the only units that can be purified.
 *
 * @param name The name of the unit.
 * @param initialHealth The maximum health points of the unit. The unit starts with this health.
 * @param attack The attack points of the enemy.
 * @param initialDefense The defense points the unit starts with.
 * @param weight The weight of the unit.
 */
class Enemy(name: String, initialHealth: Int, val attack: Int, initialDefense: Int, weight: Int) extends AbstractUnit(name, initialHealth, initialDefense, weight) with EnemiesContract {
  override def maxActionBar: Double = weight

  override def attackDamage: Int = attack
  override def magicDamage: Int = 0
  
  // Target, only enemies can be purified
  override def receivesPurify(source: Source): Boolean = {
    checkNotDefeated("Purify")
    takeDamage((health * 0.15).toInt + source.magicDamage / 2)
    true
  }
}
