package cl.uchile.dcc
package characters

trait MagicCharacter extends Character {
  /** maximum mana points of the character */
  val maxMana: Double
  /** current mana points of the character */
  protected var mana: Double
}
