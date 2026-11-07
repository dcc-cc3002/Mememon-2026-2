package cl.uchile.dcc
package controller

import model.actions.{Attack, Thunder}
import model.units.{BlackWizard, Enemy, Knight, WhiteWizard}
import model.usable.Sword

class GameControllerTest extends munit.FunSuite:
  var controller: Option[GameController] = None
  var knight: Option[Knight] = None
  var enemy: Option[Enemy] = None

  override def beforeEach(context: BeforeEach): Unit = {
    controller = Some(new GameController())
    knight = Some(new Knight("Juan", 100, 10, 10, Some(new Sword("Sword", 30, 10, None)), Nil))
    enemy = Some(new Enemy("Goblin", 100, 25, 10, 25))
    controller.get.addUnit(knight.get)
    controller.get.addUnit(enemy.get)
  }

  test("addUnit adds the units to the combat"):
    assertEquals(controller.get.units, List(knight.get, enemy.get))

  test("removeUnit takes a unit out of the combat"):
    controller.get.removeUnit(enemy.get)
    assertEquals(controller.get.units, List(knight.get))

  test("No unit has the turn when the game starts"):
    assertEquals(controller.get.currentUnit, None)

  test("nextTurn gives the turn to the first unit that fills its action bar"):
    assertEquals(controller.get.nextTurn(), Some(knight.get))
    assertEquals(controller.get.currentUnit, Some(knight.get))

  test("nextTurn without units does not give the turn to anyone"):
    assertEquals(new GameController().nextTurn(), None)

  test("An enemy can attack and move"):
    assertEquals(controller.get.availableActions(enemy.get).map(_.name), List("Attack", "Move"))

  test("A common character can also equip weapons and consume potions"):
    assertEquals(controller.get.availableActions(knight.get).map(_.name),
      List("Attack", "Move", "Equip weapon", "Consume potion"))

  test("A black wizard can also cast Thunder and Meteor"):
    val wizard = new BlackWizard("Merlin", 100, 10, 50, None, Nil, 100)
    assertEquals(controller.get.availableActions(wizard).map(_.name),
      List("Attack", "Move", "Equip weapon", "Consume potion", "Thunder", "Meteor"))

  test("A white wizard can also cast Heal and Purify"):
    val wizard = new WhiteWizard("Gandalf", 100, 10, 50, None, Nil, 100)
    assertEquals(controller.get.availableActions(wizard).map(_.name),
      List("Attack", "Move", "Equip weapon", "Consume potion", "Heal", "Purify"))

  test("A successful action ends the turn and adds one to the turn count"):
    controller.get.nextTurn()
    assertEquals(controller.get.executeAction(new Attack("Attack"), enemy.get), true)
    assertEquals(controller.get.currentUnit, None)
    assertEquals(controller.get.turnCount, 1)

  test("A failed action does not change the turn"):
    controller.get.nextTurn()
    assertEquals(controller.get.executeAction(new Thunder("Thunder"), enemy.get), false)
    assertEquals(controller.get.currentUnit, Some(knight.get))
    assertEquals(controller.get.turnCount, 0)

  test("executeAction fails when no unit has the turn"):
    assertEquals(controller.get.executeAction(new Attack("Attack"), enemy.get), false)

  test("resetGame leaves no unit with the turn and the turn count in 0"):
    controller.get.nextTurn()
    controller.get.executeAction(new Attack("Attack"), enemy.get)
    controller.get.resetGame()
    assertEquals(controller.get.currentUnit, None)
    assertEquals(controller.get.turnCount, 0)

  test("resetGame keeps the units in combat"):
    controller.get.resetGame()
    assertEquals(controller.get.units, List(knight.get, enemy.get))



  // Tests for the errors of the actions
  test("An action that throws an exception does not stop the game"):
    controller.get.nextTurn()
    enemy.get.takeDamage(100)
    assertEquals(controller.get.executeAction(new Attack("Attack"), enemy.get), false)
    assertEquals(controller.get.currentUnit, Some(knight.get))
    assertEquals(controller.get.turnCount, 0)

  test("There is no error after a successful action"):
    controller.get.nextTurn()
    controller.get.executeAction(new Attack("Attack"), enemy.get)
    assertEquals(controller.get.lastError, None)