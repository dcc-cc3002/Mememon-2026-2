package cl.uchile.dcc
package action

/**
 * Magical action
 * Type of light magic that curses the objective enemy, reducing their actual hp in 15% + magicDamage/2
 * Costs 25 mana points
 * @param name name of the spell
 * @param manaCost cost of action
 */
class Purify extends Spells {
  val name: String = "Purify"
  val manaCost: Double = 25.0
}
