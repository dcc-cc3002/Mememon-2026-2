package cl.uchile.dcc
package Characters

import Items.{Item, Weapon}

import scala.collection.mutable.ListBuffer
import scala.compiletime.uninitialized

abstract class Character(val Name:String, var HealthPoints : Int, var Defense:Int, val Weight:Int):
  var Inventory : ListBuffer[Item]  = ListBuffer.empty[Item]
  var WeaponSlot : Weapon = uninitialized //Me marcaba error si usaba = _

abstract class MagicCharacter(Name:String, HealthPoints:Int, Defense:Int, Weight:Int,var ManaPoints :Int) extends Character(Name,HealthPoints,Defense,Weight)

class BlackWizard (Name:String, HealthPoints: Int, Defense: Int, Weight:Int, ManaPoints:Int) extends MagicCharacter(Name, HealthPoints, Defense, Weight, ManaPoints)
class WhiteWizard (Name:String, HealthPoints: Int, Defense: Int, Weight:Int, ManaPoints:Int) extends MagicCharacter(Name, HealthPoints, Defense, Weight, ManaPoints)
class Knight (Name:String, HealthPoints: Int, Defense: Int, Weight:Int) extends Character(Name, HealthPoints, Defense, Weight)
class Archer (Name:String, HealthPoints: Int, Defense: Int, Weight:Int) extends Character(Name, HealthPoints, Defense, Weight)
class Thief (Name:String, HealthPoints: Int, Defense: Int, Weight:Int) extends Character(Name, HealthPoints, Defense, Weight)

