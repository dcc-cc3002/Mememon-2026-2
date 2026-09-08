package cl.uchile.dcc
package actions

import items.potions.AbstractPotion

class UsePotion extends Action {
  val name: String = "Use Potion"
  var possible_options: List[AbstractPotion]
}