package cl.uchile.dcc
package model.actions

import model.{Source, Target}

class ThrowSpell() extends Action {
  override def id: String = "throwSpell"

  override def doAction(source: Source, target: Target): Unit = ???
}