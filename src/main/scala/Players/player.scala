package cl.uchile.dcc
package Players

import Units.units


class player(val Name : String):
  private var UnitsList : List[units] = List.empty //it is var because it will change in the future
  private var Defeated: Boolean = false //it is var because it will change in the future

  //getter of the unitsList
  def getUnitsList: List[units] = UnitsList
  //getter of the variable Defeated
  def isDefeated: Boolean = Defeated