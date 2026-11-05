package cl.uchile.dcc
package model.actions

/** Contract shared by every action of the game. */
trait ActionContract {
  /** Returns the name of the action. */
  def name: String
}