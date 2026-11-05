package cl.uchile.dcc
package model.usable

import model.units.Character

class Staff(name: String, attack: Int, weight: Int,
            owner: Option[Character], magicAttack: Int) extends AbstractMagicWeapon(name, attack, weight, owner, magicAttack)

