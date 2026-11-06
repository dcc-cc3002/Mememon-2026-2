package cl.uchile.dcc
package model.actions

/** Contract shared by every action of the game. */
trait ActionContract {
  /** Returns the name of the action. */
  def name: String

  /** Executes the action from a source on a target.
   *
   * @param source The entity that performs the action.
   * @param target The entity that receives the action.
   * @return True if the action was performed successfully, false otherwise.
   */
  def execute(source: Source, target: Target): Boolean
}