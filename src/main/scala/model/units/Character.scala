package cl.uchile.dcc
package model.units

import model.usable.Weapon

trait UnitsCommon {
  def name: String
  def health: Int
  def defense: Int
  def weight: Int
  def maxActionBar: Double
}

trait Character extends UnitsCommon {
  def weapon: Option[Weapon]
  def utilities: List[String]
}

trait MagicCharacter extends Character {
  def mana: Int
}

abstract class AbstractCharacter(name: String, health: Int, defense: Int, weight: Int, val weapon: Option[Weapon],
                                 val utilities: List[String]) extends AbstractUnit(name, health, defense, weight) with Character {
  override def maxActionBar: Double = weight + 0.5 * weapon.map(_.weight).getOrElse(0)
}


abstract class AbstractMagicCharacter(name: String, health: Int, defense: Int, weight: Int, weapon: Option[Weapon], utilities: List[String],
                                      val mana: Int) extends AbstractCharacter(name, health, defense, weight, weapon, utilities) with MagicCharacter

class Knight(name: String, health: Int, defense: Int, weight:
Int, weapon: Option[Weapon], utilities: List[String]) extends AbstractCharacter(name, health, defense, weight, weapon, utilities)


class Archer(name: String, health: Int, defense: Int, weight:
Int, weapon: Option[Weapon], utilities: List[String]) extends AbstractCharacter(name, health, defense, weight, weapon, utilities)


class Thief(name: String, health: Int, defense: Int, weight:
Int, weapon: Option[Weapon], utilities: List[String]) extends AbstractCharacter(name, health, defense, weight, weapon, utilities)


class BlackWizard(name: String, health: Int, defense: Int, weight:
Int, weapon: Option[Weapon], utilities: List[String], mana: Int) extends AbstractMagicCharacter(name, health, defense, weight, weapon, utilities, mana)


class WhiteWizard(name: String, health: Int, defense: Int, weight:
Int, weapon: Option[Weapon], utilities: List[String], mana: Int) extends AbstractMagicCharacter(name, health, defense, weight, weapon, utilities, mana)








