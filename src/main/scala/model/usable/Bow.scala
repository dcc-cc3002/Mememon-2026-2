package cl.uchile.dcc
package model.usable

import model.units.Character

class Bow(name: String, attack: Int, weight: Int,
          owner: Option[Character]) extends AbstractWeapon(name, attack, weight, owner)
