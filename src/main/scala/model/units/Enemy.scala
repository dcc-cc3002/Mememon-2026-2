package cl.uchile.dcc
package model.units

class Enemy(
           name: String,
           healthPoints: Int,
           val attackPoints: Int,
           defensePoints: Int,
           weight: Int
           ) extends Unit(name, healthPoints, defensePoints, weight)