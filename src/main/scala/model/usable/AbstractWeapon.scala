package cl.uchile.dcc
package model.usable

import model.units.Character

/** Base class for all weapons.
 *
 * @param name The name of the weapon.
 * @param attack The attack points of the weapon.
 * @param weight The weight of the weapon.
 * @param owner The character that owns the weapon, if any.
 */
abstract class AbstractWeapon(val name: String, val attack: Int, val weight: Int, initialOwner: Option[Character]) extends Weapon {
  private var currentOwner: Option[Character] = initialOwner

  override def owner: Option[Character] = currentOwner
  override def magicAttack: Int = 0
  override def changeOwner(newOwner: Option[Character]): Unit =
    currentOwner = newOwner
}

