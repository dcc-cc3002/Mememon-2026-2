package cl.uchile.dcc
package Units

import cl.uchile.dcc.Items.{Item, Weapon}

import scala.collection.mutable.ListBuffer
import scala.compiletime.uninitialized

abstract class Character(val Name:String, var HP:Int, var Defense:Int, val Weight:Int) extends Units:
  var Inventory: ListBuffer[Item] = ListBuffer.empty[Item]
  var WeaponSlot: Weapon = uninitialized  //It doesn´t work with =_ anymore
  private var ActionBar: Int = 0
  def ResetBar():Unit = {
    ActionBar = 0
  }
  def AddBar(actionQuantity:Int):Unit = {
    ActionBar+=actionQuantity
  }
  def GetActionBar():Int = ActionBar


