package cl.uchile.dcc
package controller

import Actions.action
import PatronObserver.{Observer, Subject}
import Players.player
import Source_target.{source, target}
import TurnScheduler.turnScheduler
import Units.units

//gameController is the one that takes the responsibility of the gameplay itself
class GameController extends Observer[Boolean] {
  //each GameController have a scheduler that cannot be affected from the outside
  private var scheduler: turnScheduler = new turnScheduler
  //currentUnit helps to distribute the order of the gameplay
  private var currentUnit: Option[units] = None
  //nextUnit helps to have order in the turns
  private var nextUnit: Option[units] = None
  
  //putUnit helps to implement a new character to the game
  def putUnit(Player:player,unit:units):Unit = {
    Player.summon(unit)
    scheduler.PutUnit(unit)
  }

  //getCurrentUnit is a getter of CurrentUnit
  def getCurrentUnit: Option[units] = currentUnit
  
  //NextTurn is the function that keeps the game flowing, giving the units their turns
  def NextTurn(): Unit = {
    if nextUnit.isEmpty then{
      while (scheduler.turn().isEmpty) {
        scheduler.AddAllBars(1)
      }
      currentUnit = scheduler.turn()
    }else {
      currentUnit = nextUnit
      while (scheduler.turn().isEmpty) {
        scheduler.AddAllBars(1)
      }
      nextUnit = scheduler.turn()
    }
  }
  //getNextUnit is a getter of NextUnit
  def getNextUnit: Option[units] = nextUnit
  
  //AvailableActions is the responsible for keeping the game's logic, throwing an error when the player use an Action that can't use with that unit
  def AvailableActions(source:units):List[action] =
    source.AvailableActions //To implement later
  
  //Resolve receives every action that is invalid
  def Resolve(source:source, target:target, action:action):Unit = {
    try source.doAction(target,action)
    catch
      case e=>
        println(e.getMessage)
  }
  
  //resetAll is used to reset the game itself whenever someone wins or if they want to
  def resetAll():Unit = {
    scheduler = new turnScheduler()
    currentUnit = None
    nextUnit = None
  }

  override def update(subject: Subject[Boolean], response: Boolean): Unit =
    if response then
      println("A player died now")
}
//I am still looking for a better way to notify about a player defeated,
//because units don't know who is their owner (the player)
//Maybe It will be Refactorized later
