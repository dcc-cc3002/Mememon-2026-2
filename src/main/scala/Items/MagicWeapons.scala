package cl.uchile.dcc
package Items

import Actions.Action
import Sourse_target.Source
import Units.{Archer, BlackWizard, Character, Enemy, Knight, MagicCharacter, Thief, WhiteWizard}

import java.lang

abstract class MagicWeapon(Name:String, Weight:Int, PhysicalATKPoints:Int, Owner: Character, val MagicATKPoints : Int) extends Weapon(Name, Weight, PhysicalATKPoints, Owner)

class Wand(Name:String, Weight:Int, PhysicalATKPoints:Int, Owner: Character, MagicATKPoints: Int) extends MagicWeapon(Name, Weight, PhysicalATKPoints, Owner, MagicATKPoints):
  override def receiveWhiteWizardAction(source:WhiteWizard, action:Action): Unit =
    if action.Name == "EquipWeapon" then source.WeaponSlot = this //revisar como arreglarlo
  override def receiveBlackWizardAction(source: BlackWizard, action: Action): Unit =  
    if action.Name == "EquipWeapon" then source.WeaponSlot = this
  
  override def receiveEnemyAction(source: Enemy, action: Action): Unit =
    println("Enemy doesn't get weapons")

  override def receiveArcherAction(source: Archer, action: Action): Unit =
    if action.Name == "EquipWeapon" then source.WeaponSlot = this //revisar como arreglarlo
  override def receiveKnightAction(source: Knight, action: Action): Unit =
    println("Wrong weapon to this character")    
  override def receiveThiefAction(source: Thief, action: Action): Unit =
    println("Wrong weapon to this character")    
  
class Staff(Name:String, Weight:Int, PhysicalATKPoints:Int, Owner: Character, MagicATKPoints: Int) extends MagicWeapon(Name, Weight, PhysicalATKPoints, Owner, MagicATKPoints):
  override def receiveWhiteWizardAction(source:WhiteWizard, action:Action): Unit =
    if action.Name == "EquipWeapon" then source.WeaponSlot = this //revisar como arreglarlo
  override def receiveBlackWizardAction(source: BlackWizard, action: Action): Unit =
    if action.Name == "EquipWeapon" then source.WeaponSlot = this

  override def receiveEnemyAction(source: Enemy, action: Action): Unit =
    println("Enemy doesn't get weapons")

  override def receiveArcherAction(source: Archer, action: Action): Unit =
    println("Wrong weapon to this character")
  override def receiveKnightAction(source: Knight, action: Action): Unit =
    println("Wrong weapon to this character")
  override def receiveThiefAction(source: Thief, action: Action): Unit =
    println("Wrong weapon to this character")        