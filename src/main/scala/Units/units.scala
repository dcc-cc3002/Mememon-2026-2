package cl.uchile.dcc
package Units

import Source_target.{source, target}

//units it's a bad name to the units, because it can be confused with Unit, but I don't have found a better word
trait units extends source with target:
  //every unit attribute that is shared between both enemies and characters
  def Name:String
  def HP: Int
  def Defense: Int
  def Weight: Int
  def ResetBar(): Unit
  def AddBar(actionQuantity:Int):Unit
  def GetActionBar(): Int