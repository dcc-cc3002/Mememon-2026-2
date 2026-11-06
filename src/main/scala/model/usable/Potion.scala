package cl.uchile.dcc
package model.usable

import model.units.Character

/** Contract for potions that characters can consume. */
trait Potion extends usableCommon {
  /** Applies the effect of the potion on a character.
   *
   * @param character The character that consumes the potion.
   * @return True if the potion has an effect on the character, false otherwise.
   */
  def applyTo(character: Character): Boolean
}





