package cl.uchile.dcc
package Source_target

import Actions.action
import Locations.panel

//source is the class that do the action
trait source:
  def doAction(target:target, action:action):Unit
  
  def AvailableActions:List[action]
  
  protected def isAlive: Boolean
  def doAttack(target:target):Unit

  def doThunder(target: target): Unit
  def doMeteorite(target: target): Unit

  def doHeal(target: target): Unit
  def doPurification(target: target): Unit
  def setWeapon(target:target) : Unit
  def beMovedTo(target:target) : Unit
  def consumePotion(target:target) : Unit

  var currentLocation : Option[panel]