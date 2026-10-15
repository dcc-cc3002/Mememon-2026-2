package cl.uchile.dcc
package Units

import Actions.Action
import Sourse_target.Target

class Enemy(val Name:String, var HP: Int, val ATK: Int, var Defense: Int, val Weight: Int) extends Units {
  private var ActionBar: Int = 0
  def ResetBar():Unit = {
    ActionBar = 0
  }
  def AddBar(actionQuantity:Int):Unit = {
    ActionBar+=actionQuantity
  }
  def GetActionBar():Int = ActionBar
  
  def doAction(target:Target, action: Action) : Unit =
    target.receiveEnemyAction(this, action)
}