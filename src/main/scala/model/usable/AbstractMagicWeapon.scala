package cl.uchile.dcc
package model.usable

import model.units.Character

/** Base class for magic weapons.
 *
 * @param name The name of the weapon.
 * @param attack The attack points of the weapon.
 * @param weight The weight of the weapon.
 * @param owner The character that owns the weapon at the start, if any.
 * @param magicAttack The magic attack points of the weapon.
 */
abstract class AbstractMagicWeapon(name: String, attack: Int, weight: Int, owner: Option[Character], override val magicAttack: Int)
  extends AbstractWeapon(name, attack, weight, owner) with MagicWeapon

