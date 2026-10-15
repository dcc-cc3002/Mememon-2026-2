package cl.uchile.dcc
package Sourse_target

import Actions.Action

trait Source:
  def doAction(target:Target,action:Action): Unit
