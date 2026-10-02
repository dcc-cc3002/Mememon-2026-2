package cl.uchile.dcc
package character_units.characters

import items.*
import weapons.*

class Archer(name: String, HP: Int, Def: Int, Wgt: Int, isMagic: Boolean, weapon: Option[AbstractWeapon], inventory: List[Item]) 
  extends AbstractCharacter(name, HP, Def, Wgt, isMagic, weapon, inventory) {
  
  

}
