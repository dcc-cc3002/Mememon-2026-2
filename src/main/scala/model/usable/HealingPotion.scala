package cl.uchile.dcc
package model.usable

import model.units.Character

/** A potion that restores 20% of the maximum health.
 *
 * @param name The name of the potion.
 */
class HealingPotion(val name: String) extends Potion {
  override def applyTo(character: Character): Boolean = character.drinkHealingPotion()
}

