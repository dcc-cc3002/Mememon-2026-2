package cl.uchile.dcc
package Units

import Sourse_target.{Source, Target}


trait Units extends Source: //implementar targets cuando se pueda
  def Name: String
  def HP: Int
  def Defense: Int
  def Weight: Int
  def ResetBar(): Unit
  def AddBar(actionQuantity:Int):Unit
  def GetActionBar(): Int