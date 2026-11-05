package cl.uchile.dcc
package model.units

import model.usable.{Weapon, usableCommon}

trait Character extends UnitsCommon {
  def weapon: Option[Weapon]
  def utilities: List[usableCommon]
}







