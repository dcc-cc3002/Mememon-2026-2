package cl.uchile.dcc
package model.usable

import model.units.Character

/** A staff, a magic weapon.
 *
 * @param name The name of the weapon.
 * @param attack The attack points of the weapon.
 * @param weight The weight of the weapon.
 * @param owner The character that owns the weapon at the start, if any.
 * @param magicAttack The magic attack points of the weapon.
 */
class Staff(name: String, attack: Int, weight: Int,
            owner: Option[Character], magicAttack: Int) extends AbstractMagicWeapon(name, attack, weight, owner, magicAttack) {
  override def isEquippableBy(character: Character): Boolean = character.canEquipStaff
}

