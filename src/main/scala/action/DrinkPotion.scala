package cl.uchile.dcc
package action

import cl.uchile.dcc.potions.Potion
import cl.uchile.dcc.characters.{Character, MagicCharacter}
import cl.uchile.dcc.unit.{Source, Target}

/** Action of drinking a potion */

class DrinkPotion extends ItemAction {
  val name: String = "Drink potion"
  /**List of items that can be used*/
  val items: List[Potion] = Nil
}
