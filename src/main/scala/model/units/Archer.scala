package cl.uchile.dcc
package model.units

import model.usable.Weapon

class Archer(name: String, health: Int, defense: Int, weight:
Int, weapon: Option[Weapon], utilities: List[String]) extends AbstractCharacter(name, health, defense, weight, weapon, utilities)
