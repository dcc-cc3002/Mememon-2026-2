package cl.uchile.dcc
package model.units

import model.usable.{Weapon, usableCommon}

abstract class AbstractMagicCharacter(name: String, health: Int, defense: Int, weight: Int, weapon: Option[Weapon], utilities: List[usableCommon],
                                      val mana: Int) extends AbstractCharacter(name, health, defense, weight, weapon, utilities) with MagicCharacter

