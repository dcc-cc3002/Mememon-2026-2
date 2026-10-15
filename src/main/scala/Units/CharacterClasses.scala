package cl.uchile.dcc
package Units

import Actions.Action
import Sourse_target.Target

//Normal ones
class Knight (Name:String, HP: Int, Defense: Int, Weight:Int) extends Character(Name, HP, Defense, Weight):
  def doAction(target:Target,action:Action) : Unit =
    target.receiveKnightAction(this, action)
class Archer (Name:String, HP: Int, Defense: Int, Weight:Int) extends Character(Name, HP, Defense, Weight):
  def doAction(target: Target, action: Action): Unit =
    target.receiveArcherAction(this, action)
class Thief (Name:String, HP: Int, Defense: Int, Weight:Int) extends Character(Name, HP, Defense, Weight):
  def doAction(target: Target, action: Action): Unit =
    target.receiveThiefAction(this, action)
  
//I don´t know how to improve this 

//Magical ones

class BlackWizard (Name:String, HP: Int, Defense: Int, Weight:Int, ManaPoints:Int) extends MagicCharacter(Name, HP, Defense, Weight, ManaPoints):
  def doAction(target: Target, action: Action): Unit =
    target.receiveBlackWizardAction(this, action)  
class WhiteWizard (Name:String, HP: Int, Defense: Int, Weight:Int, ManaPoints:Int) extends MagicCharacter(Name, HP, Defense, Weight, ManaPoints):
  def doAction(target: Target, action: Action): Unit =
    target.receiveWhiteWizardAction(this, action)