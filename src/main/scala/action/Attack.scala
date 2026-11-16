package cl.uchile.dcc
package action


import cl.uchile.dcc.unit.{Source, Target}

/**
 * Action of attacking another unit
 * @param name name of the action
 */
class Attack extends Action {
  /** the name of this action will always be attack */
  val name: String = "Attack"
  /** a source can perform an attack on a target */
  override def doAction(source: Source, target: Target): Unit = {
    target.receiveAttack(source)
  }
}
