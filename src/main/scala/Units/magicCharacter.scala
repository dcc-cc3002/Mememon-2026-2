package cl.uchile.dcc
package Units

import Exceptions.notEnoughManaException
import Source_target.target

//common attributes and methods that makes a magicCharacter what they are
abstract class magicCharacter(Name:String, HP:Int, Defense:Int, Weight:Int, private var _ManaPoints :Int)
  extends character(Name,HP,Defense,Weight){
  def ManaPoints: Int = _ManaPoints
  def ManaPoints_(value: Int): Unit = {
    if value<0 then throw notEnoughManaException("Cannot cast a spell without mana")
    _ManaPoints = value
  }
  
  val MaxMana:Int = _ManaPoints

  override def consumePotion(target: target): Unit = {
    target.beConsumed(this)
  }
}

