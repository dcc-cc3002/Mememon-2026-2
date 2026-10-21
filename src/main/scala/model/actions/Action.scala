package cl.uchile.dcc
package model.actions

import cl.uchile.dcc.model.Source
import cl.uchile.dcc.model.Target

trait Action {
  def id: String
  def doAction(source: Source, target: Target): Unit
}