package cl.uchile.dcc
package model.units

/** Contract for characters that can use magic. */
trait MagicCharacter extends Character {
  /** Returns the mana points of the character. */
  def mana: Int
}
