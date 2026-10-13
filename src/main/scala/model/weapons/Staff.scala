package cl.uchile.dcc
package model.weapons

class Staff(
             name: String,
             attackPoints: Int,
             weight: Int,
             magicAttackPoints: Int
           ) extends MagicWeapon(name, attackPoints, weight, magicAttackPoints)