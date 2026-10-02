package cl.uchile.dcc
package map

import character_units.CharacterUnit

trait Panel {
  val coordinates: (Int, Int)
  var units_inside: List[CharacterUnit]
}
