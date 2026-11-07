package cl.uchile.dcc
package model.actions

import model.usable.Weapon

/** Action to equip a weapon.
 *
 * @param name The name of the action.
 * @param objects The usable objects the action can use.
 */
class EquipWeapon(val name: String, val objects: List[Weapon]) extends ActionWithUsable {
  override def execute(source: Source, target: Target): Boolean =
    objects.lastOption.exists(weapon => source.equipWeaponTo(target, weapon))
}

