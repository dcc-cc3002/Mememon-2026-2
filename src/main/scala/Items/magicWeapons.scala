package cl.uchile.dcc
package Items

import Units.character

//abstract class to give the difference between a normal weapon and a magical one
abstract class MagicWeapon(Name:String, Weight:Int, PhysicalATKPoints:Int, Owner: character, val MagicATKPoints : Int) extends Weapon(Name,Weight, PhysicalATKPoints, Owner)

//implement the Wand, a magical weapon
class Wand(Weight:Int, PhysicalATKPoints:Int, Owner: character, MagicATKPoints: Int,Name:String = "Wand") extends MagicWeapon(Name, Weight, PhysicalATKPoints, Owner, MagicATKPoints)
//implements the staff, a magical weapon
class Staff(Weight:Int, PhysicalATKPoints:Int, Owner: character, MagicATKPoints: Int, Name:String = "Staff") extends MagicWeapon(Name, Weight, PhysicalATKPoints, Owner, MagicATKPoints)
