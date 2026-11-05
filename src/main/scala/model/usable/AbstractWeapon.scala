package cl.uchile.dcc
package model.usable

import model.units.Character

abstract class AbstractWeapon(val name: String, val attack: Int, val weight: Int, val owner: Option[Character]) extends Weapon

