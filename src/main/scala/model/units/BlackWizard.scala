package cl.uchile.dcc
package model.units

import model.usable.{Weapon, usableCommon}

class BlackWizard(name: String, health: Int, defense: Int, weight:
Int, weapon: Option[Weapon], utilities: List[usableCommon], mana: Int) extends AbstractMagicCharacter(name, health, defense, weight, weapon, utilities, mana)

