package cl.uchile.dcc
package model.actions

/** White magic spell that damages a target enemy.
 *
 * @param name The name of the action.
 */
class Purify(val name: String) extends ActionContract {
  override def execute(source: Source, target: Target): Boolean =
    source.purifyTo(target)
}
