package cl.uchile.dcc
package model.units

abstract class CommonCharacter(name: String,
                               healthPoints: Int,
                               defensePoints: Int,
                               weight: Int
                               ) extends Character(name, healthPoints, defensePoints, weight)

