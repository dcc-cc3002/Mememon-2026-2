package cl.uchile.dcc
package model.weapons

class Wand(
            name: String,
            attackPoints: Int,
            weight: Int,
            magicAttackPoints: Int
          ) extends MagicWeapon(name, attackPoints, weight, magicAttackPoints)