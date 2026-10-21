package cl.uchile.dcc
package model

import cl.uchile.dcc.model.actions.Action

trait Target {
  def receiveAction(action: Action, source: Source): Unit
}