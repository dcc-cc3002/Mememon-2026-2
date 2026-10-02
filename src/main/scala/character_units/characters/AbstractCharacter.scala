package cl.uchile.dcc
package character_units.characters

import items.*
import weapons.*

abstract class AbstractCharacter(
                                  val name: String,
                                  var HP: Int,
                                  var Def: Int,
                                  var Wgt: Int,
                                  val isMagic: Boolean,
                                  var weapon: Option[AbstractWeapon],
                                  var inventory: List[Item]
                                ) extends Character{

  //It's better that each unit has its own action bar
  var actionBar: Float = 0.0


}
