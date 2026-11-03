package cl.uchile.dcc.controller

import cl.uchile.dcc.models._
/**
 * Controlador principal del juego.
 * En esta clase debes implementar la lógica que conecta las distintas
 * entidades de tu modelo, maneja los turnos, y ejecuta las acciones.
 */
class GameController {
  
  // Instantiate the TurnScheduler
  private val scheduler = new TurnScheduler()

  // Store an Entity to perfectly match the scheduler's type.
  // Using Option because at the start (or after a reset) no one is playing.
  private var currentUnit: Option[Entity] = None

  // 1. Get the unit currently playing its turn.
  def getCurrentUnit: Option[Entity] = currentUnit

  // 2. Decide which unit will play the next turn.
  def nextTurn(): Unit =
    // Use the exact method defined in the TurnScheduler
    currentUnit = scheduler.getNextUnit

    currentUnit match
      case Some(unit) =>
        // Reset its action bar because it's its turn to play
        scheduler.resetActionBar(unit)
      case None =>
        // If no one is ready, advance the "time"
        scheduler.increaseActionBars(1.0)
        // Recursive call until someone is ready
        nextTurn()

  // 3. Get the available actions for a specific unit.
  def getAvailableActions(unit: Entity): List[Action] =
    unit match
      // If the entity fulfills the Source contract (characters and enemies), return its actions
      case source: Source => source.availableActions
      case _ => List() // If not (e.g., an inanimate entity), it has no actions

  // 4. Execute an action from a unit against a target.
  def executeAction(actionId: String, target: Target): Unit =
    currentUnit match
      case Some(source: Source) => // Verify that the current unit can act (is a Source)
        source.getAction(actionId) match
          case Some(action) =>
            // Triple Dispatch returns a boolean
            val success = source.doAction(action, target)

            // Only advance the turn if the action was successful
            if success then
              nextTurn()

          case None => () // The action does not exist in its list
      case _ => () // No active unit or it is not a Source

  // 5. Reset the game state.
  def resetGame(): Unit =
    currentUnit = None
  // Clean up the scheduler for a new battle
  // scheduler.reset() // Implement this in TurnScheduler if not already present
  // Add this inside GameController to delegate to the scheduler
  def addUnit(unit: Entity): Unit = scheduler.addUnit(unit)
}