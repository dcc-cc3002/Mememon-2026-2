package cl.uchile.dcc
package character_units.enemies

import character_units.CharacterUnit

trait Enemy extends CharacterUnit {
  val name: String
  var HP: Int
  var Atk: Int
  var Def: Int
  var Wgt: Int

}
