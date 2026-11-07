package cl.uchile.dcc
package model.actions

/** Black magic spell that damages every unit in a target panel.
 *
 * @param name The name of the action.
 */
class Meteor(val name: String) extends ActionContract {
  override def execute(source: Source, target: Target): Boolean =
    source.meteorTo(target)
}

