package cl.uchile.dcc
package Units

trait Units:
  def Name: String
  def HP: Int
  def Defense: Int
  def Weight: Int
  def ResetBar(): Unit
  def AddBar(actionQuantity:Int):Unit
  def GetActionBar():Int