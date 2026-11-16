package cl.uchile.dcc
package Units

import Actions.{action, attack, move}
import Exceptions.{deadException, invalidInputException, invalidWeaponToSpellException, notEnoughManaException, weaponUnequippedException}
import Items.{MagicWeapon, NormalWeapon}
import Locations.panel
import Source_target.{source, target}

//abstractUnits helps to implement some common functions between an enemy and a character
abstract class abstractUnits(protected var _HP:Int, protected var _Defense:Int) extends units {
  def HP:Int = _HP
  def HP_(value:Int):Unit = _HP = value

  val MaxHP : Int = _HP

  def Defense: Int = _Defense
  def Defense_(value: Int): Unit = _Defense = value
  
  var currentLocation: Option[panel] = None

  def AvailableActions: List[action] = List(new move(), new attack())

  def doAction(target: target, action: action): Unit = {
    if !target.isAlive then throw deadException("Target unit died before")
    if !this.isAlive then throw deadException("Source unit died before")
    action.Act(this, target)
    this.ResetBar()
  }

  private var ActionBar: Int = 0

  def ResetBar(): Unit =
    ActionBar = 0

  def AddBar(actionQuantity: Int): Unit =
    ActionBar += actionQuantity

  def GetActionBar(): Int = ActionBar

  def isAlive: Boolean = HP > 0

  override def receiveAttackFromCharacter(source: character): Unit = {
    source.WeaponSlot match {
      case Some(ownWeapon) =>
        _HP = _HP - ownWeapon.ATKPoints
      case None =>
        throw weaponUnequippedException("Cannot receive an attack from this source")
    }
  }

  override def receiveAttackFromEnemy(source: enemy): Unit = {
    _HP = _HP - source.ATK
  }

  override def receiveThunder(source: BlackWizard): Unit =
    source.WeaponSlot match {
      case Some(ownWeapon:MagicWeapon) =>
        if source.ManaPoints <20 then throw notEnoughManaException("Cannot cast thunder without the right amount of mana")
        _HP = _HP - ownWeapon.MagicATKPoints
        source.ManaPoints_(source.ManaPoints - 30)
      case Some(ownWeapon:NormalWeapon) =>
        throw invalidWeaponToSpellException("Cannot receive Thunder from this weapon")
      case None =>
        throw weaponUnequippedException("Cannot receive Thunder from an unequipped source")
      case _ => throw invalidInputException("Cannot receive Thunder from this source")
    }

  override def receiveMeteorite(source: source): Unit =
    throw invalidInputException("Units cannot receive Meteorite directly")

  override def beSet(source: character): Unit =
    throw invalidInputException("Cannot set a Unit like a Weapon")

  override def beMovedTo(target: target): Unit =
    target.setNewPosition(this)
    
  override def beConsumed(character: character) : Unit =
    throw invalidInputException("A unit cannot be consumed")  

  override def setNewPosition(source: abstractUnits): Unit = throw invalidInputException("Cannot move into a Unit")
}