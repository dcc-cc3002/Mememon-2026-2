package cl.uchile.dcc
package model.actions

import model.panels.{Panel, PanelsList}
import model.units.{Enemy, Knight}

class MoveTest extends munit.FunSuite:
  var move: Option[ActionContract] = None
  var knight: Option[Knight] = None
  var origin: Option[Panel] = None

  override def beforeEach(context: BeforeEach): Unit = {
    PanelsList = Nil
    move = Some(new Move("Move"))
    knight = Some(new Knight("Juan", 100, 10, 50, None, Nil))
    origin = Some(new Panel(0, 0, List(knight.get)))
  }

  // Partition tests
  test("A unit moves to an adjacent panel"):
    val destination = new Panel(0, 1, Nil)
    assertEquals(knight.get.doAction(move.get, destination), true)
    assertEquals(destination.units, List(knight.get))
    assertEquals(origin.get.units, Nil)

  test("An enemy can also move"):
    val enemy = new Enemy("Goblin", 100, 25, 10, 40)
    val start = new Panel(5, 5, List(enemy))
    val destination = new Panel(6, 5, Nil)
    assertEquals(enemy.doAction(move.get, destination), true)
    assertEquals(destination.units, List(enemy))
    assertEquals(start.units, Nil)

  test("A unit cannot move to a panel that is not adjacent"):
    val farPanel = new Panel(2, 2, Nil)
    assertEquals(knight.get.doAction(move.get, farPanel), false)
    assertEquals(farPanel.units, Nil)
    assertEquals(origin.get.units, List(knight.get))

  test("A unit cannot move to another unit"):
    val enemy = new Enemy("Goblin", 100, 25, 10, 40)
    assertEquals(knight.get.doAction(move.get, enemy), false)

  // Edge case tests
  test("A unit that is not on any panel cannot move"):
    val outsider = new Knight("Pedro", 100, 10, 50, None, Nil)
    val destination = new Panel(1, 0, Nil)
    assertEquals(outsider.doAction(move.get, destination), false)
    assertEquals(destination.units, Nil)

  test("A unit cannot move to the panel where it already is"):
    assertEquals(knight.get.doAction(move.get, origin.get), false)
    assertEquals(origin.get.units, List(knight.get))

