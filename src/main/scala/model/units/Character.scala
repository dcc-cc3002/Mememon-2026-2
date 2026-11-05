package cl.uchile.dcc
package model.units

import model.usable.Weapon

trait Character extends UnitsCommon {
  def weapon: Option[Weapon]
  def utilities: List[String]
}







