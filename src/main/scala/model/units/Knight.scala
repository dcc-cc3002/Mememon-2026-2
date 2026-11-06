package cl.uchile.dcc
package model.units

import model.usable.{Weapon, usableCommon}

/** A knight, a common character.
 *
 * It can equip: swords, daggers, bows.
 *
 * @param name The name of the unit.
 * @param health The maximum health points of the unit.
 * @param defense The defense points the unit starts with.
 * @param weight The weight of the unit.
 * @param weapon The weapon the character starts with, if any.
 * @param utilities The inventory of usable items the character starts with.
 */
class Knight(name: String, health: Int, defense: Int, weight:
Int, weapon: Option[Weapon], utilities: List[usableCommon]) extends AbstractCharacter(name, health, defense, weight, weapon, utilities) {
  override def canEquipSword: Boolean = true
  override def canEquipDagger: Boolean = true
  override def canEquipBow: Boolean = true
}

