package cl.uchile.dcc
package model.units

import model.usable.{Weapon, usableCommon}

/** Base class for all characters.
 *
 * Its action bar maximum is its weight plus half the weight of its weapon.
 *
 * @param name The name of the unit.
 * @param health The health points of the unit.
 * @param defense The defense points of the unit.
 * @param weight The weight of the unit.
 * @param weapon The weapon equipped by the character, if any.
 * @param utilities The inventory of usable items of the character.
 */
abstract class AbstractCharacter(name: String, health: Int, defense: Int, weight: Int, val weapon: Option[Weapon],
                                 val utilities: List[usableCommon]) extends AbstractUnit(name, health, defense, weight) with Character {
  override def maxActionBar: Double = weight + 0.5 * weapon.map(_.weight).getOrElse(0)
}
