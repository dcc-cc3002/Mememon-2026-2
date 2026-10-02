package cl.uchile.dcc
package model.weapons

abstract class CommonWeapon(
                           name: String,
                           attackPoints: Int,
                           weight: Int
                           ) extends BaseWeapon(name, attackPoints, weight)