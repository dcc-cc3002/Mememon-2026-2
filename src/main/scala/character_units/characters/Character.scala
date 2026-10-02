package cl.uchile.dcc
package character_units.characters

import items.Item
import items.weapons.AbstractWeapon
import character_units.CharacterUnit

trait Character extends CharacterUnit{
  val name: String
  var HP: Int
  var Def: Int
  var Wgt: Int
  val isMagic: Boolean
  var weapon: Option[AbstractWeapon]
  var inventory: List[Item]
  
  
  var actionBar: Float


}
