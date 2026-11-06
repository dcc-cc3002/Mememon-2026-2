package cl.uchile.dcc
package model.actions

import model.{Source, Target}

class ConsumePotion() extends Action {
  override def id: String = "consumePotion"

  override def doAction(source: Source, target: Target): Unit = ???
}