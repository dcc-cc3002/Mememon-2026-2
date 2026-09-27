package cl.uchile.dcc
package Items

import Units.Character
import Items.Item

abstract class Weapon(val Name : String, val Weight : Int, val PhysicalATKPoints : Int, val Owner: Character) extends Item


class Dagger(Name:String, Weight:Int, PhysicalATKPoints:Int, Owner: Character) extends Weapon(Name, Weight, PhysicalATKPoints, Owner)
class Sword(Name:String, Weight:Int, PhysicalATKPoints:Int, Owner: Character) extends Weapon(Name, Weight, PhysicalATKPoints, Owner)
class Bow(Name:String, Weight:Int, PhysicalATKPoints:Int, Owner: Character) extends Weapon(Name, Weight, PhysicalATKPoints, Owner)
