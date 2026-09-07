package cl.uchile.dcc
package Items

import Characters.Character
import Items.Item

abstract class Weapon(val Name : String, val Weight : Int, val PhysicalATKPoints : Int, val Owner: Character) extends Item

abstract class MagicWeapon(Name:String, Weight:Int, PhysicalATKPoints:Int, Owner: Character, val MagicATKPoints : Int) extends Weapon(Name, Weight, PhysicalATKPoints, Owner)

class Dagger(Name:String, Weight:Int, PhysicalATKPoints:Int, Owner: Character) extends Weapon(Name, Weight, PhysicalATKPoints, Owner)
class Sword(Name:String, Weight:Int, PhysicalATKPoints:Int, Owner: Character) extends Weapon(Name, Weight, PhysicalATKPoints, Owner)
class Bow(Name:String, Weight:Int, PhysicalATKPoints:Int, Owner: Character) extends Weapon(Name, Weight, PhysicalATKPoints, Owner)
class Wand(Name:String, Weight:Int, PhysicalATKPoints:Int, Owner: Character, MagicATKPoints: Int) extends MagicWeapon(Name, Weight, PhysicalATKPoints, Owner, MagicATKPoints)
class Staff(Name:String, Weight:Int, PhysicalATKPoints:Int, Owner: Character, MagicATKPoints: Int) extends MagicWeapon(Name, Weight, PhysicalATKPoints, Owner, MagicATKPoints)
