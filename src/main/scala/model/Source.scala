package cl.uchile.dcc
package model

import cl.uchile.dcc.model.actions.Action

trait Source {
  def name: String;
  def actions: List[Action]
  def getAction(id: String): Option[Action] = {
    actions.find(action => action.id == id)
  }
  def executeAction(id: String, target: Target): Unit = {
    val action = getAction(id).getOrElse {
      throw new IllegalArgumentException("Action not found: " + id)
    }
    action.doAction(this, target)
  }
}