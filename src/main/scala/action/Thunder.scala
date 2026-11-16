package cl.uchile.dcc
package action

/**
 * Magical action
 * Type of dark magic that reduces hp of the objective unit in magicDamage
 * Costs 20 mana points
 * @param name name of the spell
 * @param manaCost cost of action
 */

class Thunder extends Spells {
  val name: String = "Thunder"
  val manaCost: Double = 20.0
}
