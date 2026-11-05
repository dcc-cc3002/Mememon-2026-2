package cl.uchile.dcc
package model.usable

import model.units.Character

/** A dagger, a common weapon.
 *
 * @param name The name of the weapon.
 * @param attack The attack points of the weapon.
 * @param weight The weight of the weapon.
 * @param owner The character that owns the weapon, if any.
 */
class Dagger(name: String, attack: Int, weight: Int,
             owner: Option[Character]) extends AbstractWeapon(name, attack, weight, owner)

