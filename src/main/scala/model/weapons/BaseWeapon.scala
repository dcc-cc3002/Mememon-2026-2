package cl.uchile.dcc
package model.weapons

import model.Weapon
import model.units.Character

abstract class BaseWeapon(
                         val name: String,
                         val attackPoints: Int,
                         val weight: Int,
                         var owner: Option[Character] = None
                         ) extends Weapon