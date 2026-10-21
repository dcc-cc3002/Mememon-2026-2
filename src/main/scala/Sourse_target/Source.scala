package cl.uchile.dcc
package Sourse_target

import Actions.Action


trait Source:
  def doAction(target:Target,action:Action):Unit
  protected def isAlive: Boolean
  def doAttack(target:Target):Unit

  def doThunder(target: Target): Unit
  def doMeteorite(target: Target): Unit

  def doHeal(target: Target): Unit
  def doPurification(target: Target): Unit