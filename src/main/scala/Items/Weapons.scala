package cl.uchile.dcc
package Items

import Items.Item
import cl.uchile.dcc.Players.Player

abstract class Weapon(val Name : String, val Weight : Int, val PhysicalATKPoints : Int, val Owner: Player) extends Item

abstract class MagicWeapon(Name:String, Weight:Int, PhysicalATKPoints:Int, Owner: Player, val MagicATKPoints : Int) extends Weapon(Name, Weight, PhysicalATKPoints, Owner)

class Dagger(Name:String, Weight:Int, PhysicalATKPoints:Int, Owner: Player) extends Weapon(Name, Weight, PhysicalATKPoints, Owner)
class Sword(Name:String, Weight:Int, PhysicalATKPoints:Int, Owner: Player) extends Weapon(Name, Weight, PhysicalATKPoints, Owner)
class Bow(Name:String, Weight:Int, PhysicalATKPoints:Int, Owner: Player) extends Weapon(Name, Weight, PhysicalATKPoints, Owner)
class Wand(Name:String, Weight:Int, PhysicalATKPoints:Int, Owner: Player, MagicATKPoints: Int) extends MagicWeapon(Name, Weight, PhysicalATKPoints, Owner, MagicATKPoints)
class Stick(Name:String, Weight:Int, PhysicalATKPoints:Int, Owner: Player, MagicATKPoints: Int) extends MagicWeapon(Name, Weight, PhysicalATKPoints, Owner, MagicATKPoints)
