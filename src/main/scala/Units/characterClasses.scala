package cl.uchile.dcc
package Units


import Actions.*
import Exceptions.{invalidInputException, invalidSpellException, invalidWeaponToSpellException, weaponUnequippedException}
import Items.{MagicWeapon, NormalWeapon}
import Source_target.target

//Normal ones
class Knight (_HP: Int, _Defense: Int, override val Weight:Int, override val Name:String = "Knight" ) extends normalCharacter(Name, _HP, _Defense, Weight) {

  var AvailableWeapons: List[String] = List("Sword", "Dagger", "Bow")

}
class Archer (_HP: Int, _Defense: Int,override val Weight:Int, override val Name:String = "Archer") extends normalCharacter(Name, _HP, _Defense, Weight) {

  var AvailableWeapons: List[String] = List("Sword", "Wand", "Bow")

}
class Thief (_HP: Int, _Defense: Int,override val Weight:Int, override val Name:String = "Thief") extends normalCharacter(Name, _HP, _Defense, Weight) {

  var AvailableWeapons: List[String] = List("Sword", "Dagger")

}

//magical ones
class BlackWizard ( _HP: Int, _Defense: Int, override val Weight:Int, _ManaPoints:Int,override val Name:String = "BlackWizard") extends magicCharacter(Name, _HP, _Defense, Weight, _ManaPoints) {

  override def AvailableActions: List[action] =
    new meteorite() :: new thunder() :: super.AvailableActions

  var AvailableWeapons: List[String] = List("Dagger", "Wand", "Staff")
  override def doHeal(target: target): Unit =
    throw invalidSpellException("This unit cannot cast doHeal")

  override def doPurification(target: target): Unit =
    throw invalidSpellException("This unit cannot cast doPurification")

  override def doThunder(target: target): Unit = {
    this.WeaponSlot match {
      case Some(ownWeapon:MagicWeapon) =>
        this.ManaPoints_(this.ManaPoints-20)
        target.receiveThunder(this)
      case Some(ownWeapon:NormalWeapon) =>
        throw invalidWeaponToSpellException("Cannot use this weapon to cast doThunder")
      case None =>
        throw weaponUnequippedException("Cannot cast doThunder without a weapon")
      case _ => throw invalidInputException("Cannot cast doThunder")
    }
  }

  override def doMeteorite(target: target): Unit = {
    this.WeaponSlot match {
      case Some(ownWeapon: MagicWeapon) =>
        this.ManaPoints_(this.ManaPoints-50)
        target.receiveMeteorite(this)
      case Some(ownWeapon: NormalWeapon) =>
        throw invalidWeaponToSpellException("Cannot use this weapon to cast doMeteorite")
      case None =>
        throw weaponUnequippedException("Cannot cast doMeteorite without a weapon")
      case _ => throw invalidInputException("Cannot cast doMeteorite")
    }
  }
}
class WhiteWizard( _HP: Int, _Defense: Int, override val Weight: Int, _ManaPoints: Int,override val Name:String = "WhiteWizard") extends magicCharacter(Name, _HP, _Defense, Weight, _ManaPoints) {
  override def AvailableActions: List[action] =
    new heal() :: new purification() :: super.AvailableActions

  var AvailableWeapons: List[String] = List("Bow", "Wand", "Staff")
  override def doHeal(target: target): Unit =
    this.WeaponSlot match {
      case Some(ownWeapon: MagicWeapon) =>
        this.ManaPoints_(this.ManaPoints - 15)
        target.receiveHeal(this)
      case Some(ownWeapon: NormalWeapon) =>
        throw invalidWeaponToSpellException("Cannot use this weapon to cast doHeal")
      case None =>
        throw weaponUnequippedException("Cannot cast doHeal without a weapon")
      case _ => throw invalidInputException("Cannot cast doHeal")
    }
  override def doPurification(target: target): Unit =
    this.WeaponSlot match {
      case Some(ownWeapon: MagicWeapon) =>
        this.ManaPoints_(this.ManaPoints - 25)
        target.receivePurification(this)
      case Some(ownWeapon: NormalWeapon) =>
        throw invalidWeaponToSpellException("Cannot use this weapon to cast doPurification")
      case None =>
        throw weaponUnequippedException("Cannot cast doPurification without a weapon")
      case _ => throw invalidInputException("Cannot cast doPurification")
    }

  override def doThunder(target: target): Unit =
    throw invalidSpellException("this unit cannot cast doThunder")

  override def doMeteorite(target: target): Unit =
    throw invalidSpellException("this unit cannot cast doMeteorite")

}
