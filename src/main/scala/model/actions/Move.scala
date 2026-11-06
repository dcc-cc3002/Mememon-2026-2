package cl.uchile.dcc
package model.actions

import model.{Source, Target}

class Move() extends Action {
  override def id: String = "move"

  override def doAction(source: Source, target: Target): Unit = ???
}