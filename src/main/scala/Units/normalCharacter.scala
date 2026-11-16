package cl.uchile.dcc
package Units

import Exceptions.{invalidPotionException, invalidSpellException}
import Items.magicPotion
import Source_target.target

//it's used to set the difference between a magicCharacter and a normal one
abstract class normalCharacter(override val Name:String, _HP:Int, _Defense:Int,override val Weight:Int) extends character(Name,_HP,_Defense,Weight){
  override def doHeal(target: target): Unit =
    throw invalidSpellException("This unit cannot cast doHeal")

  override def doPurification(target: target): Unit =
    throw invalidSpellException("This unit cannot cast doPurification")

  override def doThunder(target: target): Unit =
    throw invalidSpellException("this unit cannot cast doThunder")

  override def doMeteorite(target: target): Unit =
    throw invalidSpellException("This unit cannot cast doMeteorite")

  override def consumePotion(target: target): Unit = {
    target match{
      case p:magicPotion =>
        target.beConsumed(this)
      case _ =>
        throw invalidPotionException("this character cannot consume magic potions")
    }
  }  
}
