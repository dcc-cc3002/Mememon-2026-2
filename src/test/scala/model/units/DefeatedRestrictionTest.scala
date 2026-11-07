package cl.uchile.dcc
package model.units

import model.actions.{Attack, Heal, Purify, Thunder}
import model.exceptions.InvalidActionException
import model.usable.{Sword, Wand}

class DefeatedRestrictionTest extends munit.FunSuite:
  var knight: Option[Knight] = None
  var enemy: Option[Enemy] = None

  override def beforeEach(context: BeforeEach): Unit = {
    knight = Some(new Knight("Juan", 100, 10, 50, Some(new Sword("Sword", 30, 10, None)), Nil))
    enemy = Some(new Enemy("Goblin", 100, 25, 10, 40))
  }

  // Partition tests
  test("A defeated enemy cannot be attacked"):
    enemy.get.takeDamage(100)
    var exceptionThrown = false
    try {
      knight.get.doAction(new Attack("Attack"), enemy.get)
    } catch {
      case e: InvalidActionException => exceptionThrown = true
    }
    assertEquals(exceptionThrown, true)

  test("A defeated unit cannot receive Thunder"):
    val wizard = new BlackWizard("Merlin", 100, 10, 50, Some(new Wand("Wand", 5, 2, None, 30)), Nil, 100)
    enemy.get.takeDamage(100)
    var exceptionThrown = false
    try {
      wizard.doAction(new Thunder("Thunder"), enemy.get)
    } catch {
      case e: InvalidActionException => exceptionThrown = true
    }
    assertEquals(exceptionThrown, true)
    assertEquals(wizard.mana, 100)

  test("A defeated character cannot be healed"):
    val wizard = new WhiteWizard("Gandalf", 100, 10, 50, Some(new Wand("Wand", 5, 2, None, 20)), Nil, 100)
    knight.get.takeDamage(100)
    var exceptionThrown = false
    try {
      wizard.doAction(new Heal("Heal"), knight.get)
    } catch {
      case e: InvalidActionException => exceptionThrown = true
    }
    assertEquals(exceptionThrown, true)
    assertEquals(knight.get.health, 0)
    assertEquals(wizard.mana, 100)

  test("A defeated enemy cannot be purified"):
    val wizard = new WhiteWizard("Gandalf", 100, 10, 50, Some(new Wand("Wand", 5, 2, None, 20)), Nil, 100)
    enemy.get.takeDamage(100)
    var exceptionThrown = false
    try {
      wizard.doAction(new Purify("Purify"), enemy.get)
    } catch {
      case e: InvalidActionException => exceptionThrown = true
    }
    assertEquals(exceptionThrown, true)
    assertEquals(wizard.mana, 100)

  // Edge case tests
  test("A unit with 1 health point can still receive actions"):
    enemy.get.takeDamage(99)
    assertEquals(knight.get.doAction(new Attack("Attack"), enemy.get), true)
    assertEquals(enemy.get.health, 0)
