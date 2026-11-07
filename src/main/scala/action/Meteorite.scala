package cl.uchile.dcc
package action

/**
 * Magical action
 * Type of dark magic that reduces hp of all units inside the objective panel in magicDamage
 * Costs 50 mana points
 * @param name name of the spell
 * @param manaCost cost of action
 */
class Meteorite extends Spells {
  val name: String = "Meteorite"
  val manaCost: Double = 50.0

}
