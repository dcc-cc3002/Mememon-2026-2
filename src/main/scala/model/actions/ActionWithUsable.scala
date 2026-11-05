package cl.uchile.dcc
package model.actions

import model.usable.usableCommon

/** Contract for actions that involve usable items. */
trait ActionWithUsable extends ActionContract {
  /** Returns the usable objects the action can use. */
  def objects: List[usableCommon]
}
