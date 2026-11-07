package cl.uchile.dcc
package model.usable

import model.units.Character

/** A sword, a common weapon.
 *
 * @param name The name of the weapon.
 * @param attack The attack points of the weapon.
 * @param weight The weight of the weapon.
 * @param owner The character that owns the weapon at the start, if any.
 */
class Sword(name: String, attack: Int, weight: Int,
            owner: Option[Character]) extends AbstractWeapon(name, attack, weight, owner) {
  override def isEquippableBy(character: Character): Boolean = character.canEquipSword
}
