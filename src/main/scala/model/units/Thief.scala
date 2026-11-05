package cl.uchile.dcc
package model.units

import model.usable.{Weapon, usableCommon}

/** A thief, a common character.
 *
 * @param name The name of the unit.
 * @param health The health points of the unit.
 * @param defense The defense points of the unit.
 * @param weight The weight of the unit.
 * @param weapon The weapon equipped by the character, if any.
 * @param utilities The inventory of usable items of the character.
 */
class Thief(name: String, health: Int, defense: Int, weight:
Int, weapon: Option[Weapon], utilities: List[usableCommon]) extends AbstractCharacter(name, health, defense, weight, weapon, utilities)
