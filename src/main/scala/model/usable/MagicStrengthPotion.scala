package cl.uchile.dcc
package model.usable

import model.units.Character

/** A magic potion that increases the damage of the next spell by 50%. Only works on magic characters.
 *
 * @param name The name of the potion.
 */
class MagicStrengthPotion(val name: String) extends Potion {
  override def applyTo(character: Character): Boolean = character.drinkMagicStrengthPotion()
}
