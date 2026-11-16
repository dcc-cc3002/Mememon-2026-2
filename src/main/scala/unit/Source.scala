package cl.uchile.dcc
package unit

import cl.uchile.dcc.action.Action
import cl.uchile.dcc.unit.Target

/** Trait describing an unit capable of initializing and executing actions */
trait Source {
  /** each source unit able to perform an attack has attack damage points */
  def attackDamage: Double = 0
  /** source is able to execute diverse actions*/
  def doAction(action:Action, target: Target): Unit
}
