package cl.uchile.dcc
package model.units

import model.actions.{Attack, Move}
import model.exceptions.InvalidActionException
import model.panels.{Panel, PanelsList}
import model.usable.Sword

class HealthRestrictionTest extends munit.FunSuite:
  var attack: Option[Attack] = None
  var enemy: Option[Enemy] = None
  var target: Option[Enemy] = None

  override def beforeEach(context: BeforeEach): Unit = {
    attack = Some(new Attack("Attack"))
    enemy = Some(new Enemy("Jose", 90, 100, 55, 120))
    target = Some(new Enemy("Pedro", 90, 100, 55, 120))
  }

  // Partition tests
  test("An enemy without health cannot perform actions"):
    enemy.get.takeDamage(90)
    var exceptionThrown = false
    try {
      enemy.get.doAction(attack.get, target.get)
    } catch {
      case e: InvalidActionException => exceptionThrown = true
    }
    assertEquals(exceptionThrown, true)
    assertEquals(target.get.health, 90)

  test("A character without health cannot perform actions"):
    val knight = new Knight("Juan", 90, 10, 55, Some(new Sword("La poderosa", 30, 10, None)), Nil)
    knight.takeDamage(90)
    var exceptionThrown = false
    try {
      knight.doAction(attack.get, target.get)
    } catch {
      case e: InvalidActionException => exceptionThrown = true
    }
    assertEquals(exceptionThrown, true)
    assertEquals(target.get.health, 90)


  // Edge case tests
  test("A unit with 1 health point can still perform actions"):
    enemy.get.takeDamage(89)
    assertEquals(enemy.get.doAction(attack.get, target.get), true)
