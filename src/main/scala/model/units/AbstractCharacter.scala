package cl.uchile.dcc
package model.units

import model.usable.Weapon

abstract class AbstractCharacter(name: String, health: Int, defense: Int, weight: Int, val weapon: Option[Weapon],
                                 val utilities: List[String]) extends AbstractUnit(name, health, defense, weight) with Character {
  override def maxActionBar: Double = weight + 0.5 * weapon.map(_.weight).getOrElse(0)
}
