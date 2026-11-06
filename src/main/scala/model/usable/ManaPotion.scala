package cl.uchile.dcc
package model.usable

import model.units.Character

/** A magic potion that restores 30% of the maximum mana. Only works on magic characters.
 *
 * @param name The name of the potion.
 */
class ManaPotion(val name: String) extends Potion {
  override def applyTo(character: Character): Boolean = character.drinkManaPotion()
}
