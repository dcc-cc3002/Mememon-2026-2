package cl.uchile.dcc
package model.usable

import model.units.Character

abstract class AbstractMagicWeapon(name: String, attack: Int, weight: Int, owner: Option[Character], val magicAttack: Int)
  extends AbstractWeapon(name, attack, weight, owner) with MagicWeapon

