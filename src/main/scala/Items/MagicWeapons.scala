package cl.uchile.dcc
package Items

import Units.Character

abstract class MagicWeapon(Name:String, Weight:Int, PhysicalATKPoints:Int, Owner: Character, val MagicATKPoints : Int) extends Weapon(Name, Weight, PhysicalATKPoints, Owner)

class Wand(Name:String, Weight:Int, PhysicalATKPoints:Int, Owner: Character, MagicATKPoints: Int) extends MagicWeapon(Name, Weight, PhysicalATKPoints, Owner, MagicATKPoints)
class Staff(Name:String, Weight:Int, PhysicalATKPoints:Int, Owner: Character, MagicATKPoints: Int) extends MagicWeapon(Name, Weight, PhysicalATKPoints, Owner, MagicATKPoints)
