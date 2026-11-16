package cl.uchile.dcc
package Items

import Exceptions.invalidInputException
import Units.character

//Weapon receives a name (the type of weapon), a weight, attackpoints and a owner (to instance when they equip a weapon)
abstract class Weapon(val Name : String, val Weight : Int, val ATKPoints : Int, val Owner: character) extends AbstractItem {
  //beSet receives a source and set itself to the new owner (the source)
  override def beSet(source:character):Unit =
    source.WeaponSlot = Some(this)
  
  //beConsumed throws an error because a weapon cannot be consumed
  override def beConsumed(source: character): Unit = throw invalidInputException("A weapon cannot be consumed")
}

//normalWeapon gives the diference between a normal weapon and a magical one (they share some methods, but they are not a subclass of each other
abstract class NormalWeapon(override val Name : String,override val Weight : Int,override val ATKPoints : Int,override val Owner: character) extends Weapon(Name, Weight, ATKPoints, Owner)

//implementation of a dagger
class Dagger(Weight:Int, ATKPoints:Int, Owner: character,Name:String = "Dagger") extends NormalWeapon(Name, Weight, ATKPoints, Owner)
//implementation of a Sword  
class Sword(Weight:Int, ATKPoints:Int, Owner: character,Name:String = "Sword") extends NormalWeapon(Name, Weight, ATKPoints, Owner)
//implementation of a Bow
class Bow(Weight:Int, ATKPoints:Int, Owner: character,Name:String = "Bow") extends NormalWeapon(Name, Weight, ATKPoints, Owner)

