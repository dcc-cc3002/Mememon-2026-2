package cl.uchile.dcc
package model

import cl.uchile.dcc.model.actions.Action

trait Source {
  def name: String;
  def actions: List[Action]
}