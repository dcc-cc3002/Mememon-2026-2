package cl.uchile.dcc
package model.actions

import model.usable.Potion

/** Action to consume a potion.
 *
 * @param name The name of the action.
 * @param objects The usable objects the action can use.
 */
class ConsumePotion(val name: String, val objects: List[Potion]) extends ActionWithUsable {
  override def execute(source: Source, target: Target): Boolean =
    objects.lastOption.exists(potion => source.consumePotionTo(target, potion))
}
