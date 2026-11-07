package cl.uchile.dcc
package model.actions

/** White magic spell that heals a target character.
 *
 * @param name The name of the action.
 */
class Heal(val name: String) extends ActionContract {
  override def execute(source: Source, target: Target): Boolean =
    source.healTo(target)
}