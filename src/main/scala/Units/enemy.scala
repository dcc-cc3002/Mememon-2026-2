package cl.uchile.dcc
package Units

import Exceptions.{invalidInputException, invalidSpellException, invalidWeaponToSpellException}
import Items.MagicWeapon
import Source_target.target


//class enemy is different from a character, because it can't equip weapons or have an inventory
class enemy( _HP: Int, val ATK: Int, _Defense: Int, val Weight: Int,val Name:String="Enemy") extends abstractUnits(_HP,_Defense){

  override def doAttack(target: target): Unit =
    target.receiveAttackFromEnemy(this)

  override def receiveHeal(source: WhiteWizard): Unit = 
    throw invalidSpellException("This unit cannot be cured")

  override def receivePurification(source: WhiteWizard): Unit = {
    source.WeaponSlot match{
      case Some(ownWeapon:MagicWeapon) =>
        this._HP = math.round(this._HP*0.85).toInt - ownWeapon.MagicATKPoints
      case _ =>
        throw invalidWeaponToSpellException("Cannot cast purification without a magic weapon")
    }
  }

  override def doHeal(target: target): Unit =
    throw invalidSpellException("This unit cannot cast doHeal")

  override def doPurification(target: target): Unit =
    throw invalidSpellException("This unit cannot cast doPurification")

  override def doThunder(target: target): Unit =
    throw invalidSpellException("this unit cannot cast doThunder")

  override def doMeteorite(target: target): Unit =
    throw invalidSpellException("this unit cannot cast doMeteorite")

  override def setWeapon(target: target): Unit =
    throw invalidInputException("A enemy cannot have a weapon")

  override def consumePotion(target: target): Unit = throw invalidInputException("An enemy cannot consume potions")
}