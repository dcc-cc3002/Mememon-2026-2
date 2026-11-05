package cl.uchile.dcc
package model.actions

import model.usable.usableCommon

trait ActionWithUsable extends ActionContract {
  def objects: List[usableCommon]
}
