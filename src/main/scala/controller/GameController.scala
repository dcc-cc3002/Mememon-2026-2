package cl.uchile.dcc
package controller

import TurnScheduler.TurnScheduler

import cl.uchile.dcc.Actions.Action
import cl.uchile.dcc.Exceptions.{DeadException, InvalidInputException, InvalidPanelException, InvalidSpellException, InvalidWeaponException, InvalidWeaponToSpellException, NotEnoughManaException, WeaponUnequippedException}
import cl.uchile.dcc.Sourse_target.{Source, Target}
import cl.uchile.dcc.Units.Units

/**
  * Controlador principal del juego.
  * En esta clase debes implementar la lógica que conecta las distintas
  * entidades de tu modelo, maneja los turnos, y ejecuta las acciones.
  */
class GameController {
  private var scheduler: TurnScheduler = new TurnScheduler
  private var currentUnit: Option[Source] = None
  def getCurrentUnit: Option[Source] = currentUnit
  private var nextUnit: Option[Source] = None
  def NextTurn(): Unit = {
    currentUnit = nextUnit
    while(scheduler.turn().isEmpty){
      scheduler.AddAllBars(1)
    }
    nextUnit = scheduler.turn()
  }
  def getNextTurn: Option[Source] = nextUnit
  
  def AvailableActions(source:Source):Option[List[Action]] =
    currentUnit.AvailableActions //To implement later
    
  def Resolve(source:Source,target:Target,action:Action):Unit = {
    try source.doAction(target,action)
    catch
      case e: DeadException =>
        println(e.getMessage)
      case e: InvalidInputException =>
        println(e.getMessage)
      case e: InvalidPanelException =>
        println(e.getMessage)
      case e: InvalidSpellException =>
        println(e.getMessage)
      case e: InvalidWeaponException =>
        println(e.getMessage)
      case e: InvalidWeaponToSpellException =>
        println(e.getMessage)
      case e: NotEnoughManaException =>
        println(e.getMessage)
      case e: WeaponUnequippedException =>
        println(e.getMessage)
  }

  def resetAll():Unit = {
    scheduler = new TurnScheduler()
    currentUnit = None
    nextUnit = None
  }
}
