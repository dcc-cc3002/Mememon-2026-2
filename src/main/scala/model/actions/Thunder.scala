package cl.uchile.dcc
package model.actions

/** Black magic spell that damages a target unit.
 *
 * @param name The name of the action.
 */
class Thunder(val name: String) extends ActionContract {
  override def execute(source: Source, target: Target): Boolean =
    source.thunderTo(target)
}
