package cl.uchile.dcc
package controller
import scala.compiletime.uninitialized
import cl.uchile.dcc.models._
import munit.FunSuite

class GameControllerTest extends FunSuite {

  var controller: GameController = uninitialized
  var knight: Knight = uninitialized
  var enemy: Enemy = uninitialized
  var attackAction: AttackAction = uninitialized

  override def beforeEach(context: BeforeEach): Unit = {
    controller = new GameController()

    // We make the knight very heavy so the enemy gets the first turn naturally
    knight = new Knight("steve", hp = 100, defense = 10, weight = 15)
    enemy = new Enemy("herobrine", initialHp = 50, defense = 5, weight = 10, attack = 20)

    attackAction = new AttackAction()

    controller.addUnit(knight)
    controller.addUnit(enemy)
  }

  test("1. Turn advances only when action is successful") {
    controller.nextTurn() // Initialize the first turn

    val initialUnit = controller.getCurrentUnit
    assertEquals(initialUnit, Some(enemy), "The lighter unit (Enemy) should play first")

    // The enemy attacks the knight (valid action -> true)
    controller.executeAction("attack", knight)

    val nextUnit = controller.getCurrentUnit
    assertNotEquals(nextUnit, initialUnit, "The turn should have advanced to the next unit after a successful action")
  }

  test("2. Turn does NOT advance if action fails") {
    controller.nextTurn() // Enemy's turn

    // The enemy tries to attack itself (friendly fire -> fails -> false)
    controller.executeAction("attack", enemy)

    val currentUnit = controller.getCurrentUnit
    assertEquals(currentUnit, Some(enemy), "The turn should NOT advance because the action failed")
  }
}