package cl.uchile.dcc
package model.units

abstract class Unit(
  val name: String,
  var healthPoints: Int,
  val defensePoints: Int,
  val weight: Int
)