package cl.uchile.dcc
package model.actions

/** Action to move to an adjacent panel.
 *
 * @param name The name of the action.
 */
class Move(val name: String) extends ActionContract {
  override def execute(source: Source, target: Target): Boolean =
    source.moveTo(target)
}

