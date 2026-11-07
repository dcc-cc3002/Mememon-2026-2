package cl.uchile.dcc
package weapons

import cl.uchile.dcc.characters.Character

/** defining a common trait for the magical weapons Staff and Wand */
trait MagicWeapon extends Weapon {
  /** magic attack points used for spells */
  val magicAttack: Double
}

