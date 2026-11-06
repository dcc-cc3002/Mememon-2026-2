package cl.uchile.dcc
package model.usable

import model.units.Character

/** A potion that increases the defense by 15%.
 *
 * @param name The name of the potion.
 */
class FortitudePotion(val name: String) extends Potion {
  override def applyTo(character: Character): Boolean = character.drinkFortitudePotion()
}