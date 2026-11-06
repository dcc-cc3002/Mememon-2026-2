package cl.uchile.dcc
package model.units

import cl.uchile.dcc.model.weapons.BaseWeapon
import scala.collection.mutable.ListBuffer
import model.Usable


abstract class Character(
                        name: String,
                        healthPoints: Int,
                        defensePoints: Int,
                        weight: Int
                        ) extends Unit(name, healthPoints, defensePoints, weight){
  var equippedWeapon: Option[BaseWeapon] = None
  val inventory: ListBuffer[Usable] = ListBuffer()
}