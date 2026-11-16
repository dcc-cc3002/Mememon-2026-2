package cl.uchile.dcc
package action


/**
 * Magical action
 * Type of light magic that heals the objective character in 20% of their maxHp + magicDamage/4
 * Cost of action: 15 mana points
 * @param name name of the spell
 * @param manaCost cost of action
 * */

class Healing extends Spells{
  val name: String = "Healing Spell"
  val manaCost: Double = 15.0

}
