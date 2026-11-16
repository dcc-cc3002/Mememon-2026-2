package cl.uchile.dcc
package Players

import PatronObserver.BaseSubject
import Units.units


class player(val Name : String) extends BaseSubject[Boolean]:
  private var UnitsList : List[units] = List.empty //it is var because it will change in the future
  private var Defeated: Boolean = false //it is var because it will change in the future


  //getter of the unitsList
  def getUnitsList: List[units] = UnitsList
  //getter of the variable Defeated
  def isDefeated: Boolean = Defeated

  def summon(unit:units):Unit =
    UnitsList = unit :: UnitsList

  def AllDead():Boolean = {
    var allDead: Boolean = true
    for (unit <- UnitsList) {
      if (unit.HP > 0) {
        allDead=false}}
    if allDead then {
      Defeated = true
      notifyObservers(true)}
    allDead
  }
  
  //as I can see, maybe in the future would be nice if I implement patron factory into GameController
  //It would be nice to be able to attach every player to the controller
  