package cl.uchile.dcc
package model.actions

import model.{Source, Target}

class Attack() extends Action {
  override def id: String = "attack"

  override def doAction(source: Source, target: Target): Unit = ???
}