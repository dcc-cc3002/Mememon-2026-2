package cl.uchile.dcc
package action

import cl.uchile.dcc.unit.{GameUnit, Target}
import cl.uchile.dcc.characters.MagicCharacter
import cl.uchile.dcc.characters.magiccharacters.{BlackMage, WhiteMage}

/**
 * Here I define the trait of Spells since each of them has 
 * a cost of mana points
 */
trait Spells extends Action {
  val manaCost: Double

}
