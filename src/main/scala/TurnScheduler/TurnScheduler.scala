package cl.uchile.dcc
package TurnScheduler

import Units.Units

import scala.collection.mutable.ListBuffer



class TurnScheduler:
  //Attributes
  private def UnitsList : ListBuffer[Units] = ListBuffer[Units]()
  //Methods
  def PutUnit(puttedUnit:Units) : Unit = {
    UnitsList += puttedUnit
  }
  def GetUnit(index:Int): Units = {
    UnitsList(index)
  }
  def ResetBar(unit:Units): Unit = {
    unit.ResetBar()
  }
  def AddAllBars(ActionPoints:Int): Unit = {
    for (x <- UnitsList) {x.AddBar(ActionPoints)}
  }
  def MaxBar(unit:Units) : Int = {
    unit.Weight //Still don't know how to implement because the difference between character and enemy maxBar
  }
  private def CompletedBar(unit:Units): Boolean = {
    unit.GetActionBar()>=unit.Weight
  }
  private def CompletedUnits(): ListBuffer[Units] = { //Neither I know how to sort them nor how to manage ties
    val completed = ListBuffer[Units]()
    for (x<-UnitsList){if CompletedBar(x) then {completed += x}}
    completed
  }
  def turn():Option[Units] = {
    CompletedUnits().headOption
  }