package cl.uchile.dcc
package controller

import cl.uchile.dcc.player.Player
import cl.uchile.dcc.observer.{Observer, Subject}

/**
  * Main Controller of the game, considering all the functions
 * and actions.
 *
 * The design pattern that seems more fit for this situation
 * would be the observer one, since different groups of units will be
 * changing their state constantly during a match in the game.
 *
 * GameController will extend Observer since it will be notified
 * of all the changes in the game's units
 *
  */

class GameController extends Observer{
  /** game controller identifies players */
  private var player1: Option[Player] = None
  private var player2: Option[Player] = None
  /** gets notifications of the state of a unit */
  override def update(): Unit = {

  }
} 



