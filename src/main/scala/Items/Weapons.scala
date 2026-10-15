package cl.uchile.dcc
package Items

import Units.{Archer, BlackWizard, Character, Enemy, Knight, Thief, WhiteWizard}
import Items.Item

import cl.uchile.dcc.Actions.Action

abstract class Weapon(val Name : String, val Weight : Int, val PhysicalATKPoints : Int, val Owner: Character) extends Item


class Dagger(Name:String, Weight:Int, PhysicalATKPoints:Int, Owner: Character) extends Weapon(Name, Weight, PhysicalATKPoints, Owner):
  override def receiveWhiteWizardAction(source: WhiteWizard, action: Action): Unit =
    println("Wrong weapon to this character")

  override def receiveBlackWizardAction(source: BlackWizard, action: Action): Unit =
    if action.Name == "EquipWeapon" then source.WeaponSlot = this

  override def receiveEnemyAction(source: Enemy, action: Action): Unit =
    println("Enemy doesn't get weapons")

  override def receiveArcherAction(source: Archer, action: Action): Unit =
    println("Wrong weapon to this character")

  override def receiveKnightAction(source: Knight, action: Action): Unit =    
    if action.Name == "EquipWeapon" then source.WeaponSlot = this

  override def receiveThiefAction(source: Thief, action: Action): Unit =
    if action.Name == "EquipWeapon" then source.WeaponSlot = this

class Sword(Name:String, Weight:Int, PhysicalATKPoints:Int, Owner: Character) extends Weapon(Name, Weight, PhysicalATKPoints, Owner):
  override def receiveWhiteWizardAction(source: WhiteWizard, action: Action): Unit =
    println("Wrong weapon to this character")

  override def receiveBlackWizardAction(source: BlackWizard, action: Action): Unit =
    println("Wrong weapon to this character")

  override def receiveEnemyAction(source: Enemy, action: Action): Unit =
    println("Enemy doesn't get weapons")

  override def receiveArcherAction(source: Archer, action: Action): Unit =
    if action.Name == "EquipWeapon" then source.WeaponSlot = this

  override def receiveKnightAction(source: Knight, action: Action): Unit =
    if action.Name == "EquipWeapon" then source.WeaponSlot = this

  override def receiveThiefAction(source: Thief, action: Action): Unit =
    if action.Name == "EquipWeapon" then source.WeaponSlot = this

class Bow(Name:String, Weight:Int, PhysicalATKPoints:Int, Owner: Character) extends Weapon(Name, Weight, PhysicalATKPoints, Owner):
  override def receiveWhiteWizardAction(source: WhiteWizard, action: Action): Unit =
    if action.Name == "EquipWeapon" then source.WeaponSlot = this //revisar como arreglarlo

  override def receiveBlackWizardAction(source: BlackWizard, action: Action): Unit =
    println("Wrong weapon to this character")

  override def receiveEnemyAction(source: Enemy, action: Action): Unit =
    println("Enemy doesn't get weapons")

  override def receiveArcherAction(source: Archer, action: Action): Unit =
    if action.Name == "EquipWeapon" then source.WeaponSlot = this //revisar como arreglarlo

  override def receiveKnightAction(source: Knight, action: Action): Unit =
    if action.Name == "EquipWeapon" then source.WeaponSlot = this //revisar como arreglarlo

  override def receiveThiefAction(source: Thief, action: Action): Unit =
    println("Wrong weapon to this character")
