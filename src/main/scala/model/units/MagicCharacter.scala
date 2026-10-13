package cl.uchile.dcc
package model.units

abstract class MagicCharacter(name: String,
                              healthPoints: Int,
                              defensePoints: Int,
                              weight: Int,
                              var manaPoints: Int
                             ) extends Character(name, healthPoints, defensePoints, weight)