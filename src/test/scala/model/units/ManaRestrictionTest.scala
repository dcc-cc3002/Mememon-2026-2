package cl.uchile.dcc
package model.units

import model.actions.{Heal, Meteor, Purify, Thunder}
import model.exceptions.InvalidActionException
import model.panels.Panel
import model.usable.Wand

class ManaRestrictionTest extends munit.FunSuite:
  var enemy: Option[Enemy] = None
  var knight: Option[Knight] = None

  override def beforeEach(context: BeforeEach): Unit = {
    enemy = Some(new Enemy("Goblin", 100, 25, 10, 40))
    knight = Some(new Knight("Juan", 100, 10, 50, None, Nil))
  }

  // Partition tests
  test("A black wizard cannot cast Thunder without 20 mana points"):
    val wizard = new BlackWizard("Merlin", 100, 10, 50, Some(new Wand("Wand", 5, 2, None, 30)), Nil, 19)
    var exceptionThrown = false
    try {
      wizard.doAction(new Thunder("Thunder"), enemy.get)
    } catch {
      case e: InvalidActionException => exceptionThrown = true
    }
    assertEquals(exceptionThrown, true)
    assertEquals(wizard.mana, 19)
    assertEquals(enemy.get.health, 100)

  test("A black wizard cannot cast Meteor without 50 mana points"):
    val wizard = new BlackWizard("Merlin", 100, 10, 50, Some(new Wand("Wand", 5, 2, None, 30)), Nil, 49)
    var exceptionThrown = false
    try {
      wizard.doAction(new Meteor("Meteor"), new Panel(0, 0, List(enemy.get)))
    } catch {
      case e: InvalidActionException => exceptionThrown = true
    }
    assertEquals(exceptionThrown, true)
    assertEquals(wizard.mana, 49)
    assertEquals(enemy.get.health, 100)

  test("A white wizard cannot cast Heal without 15 mana points"):
    val wizard = new WhiteWizard("Gandalf", 100, 10, 50, Some(new Wand("Wand", 5, 2, None, 20)), Nil, 14)
    knight.get.takeDamage(50)
    var exceptionThrown = false
    try {
      wizard.doAction(new Heal("Heal"), knight.get)
    } catch {
      case e: InvalidActionException => exceptionThrown = true
    }
    assertEquals(exceptionThrown, true)
    assertEquals(wizard.mana, 14)
    assertEquals(knight.get.health, 50)

  test("A white wizard cannot cast Purify without 25 mana points"):
    val wizard = new WhiteWizard("Gandalf", 100, 10, 50, Some(new Wand("Wand", 5, 2, None, 20)), Nil, 24)
    var exceptionThrown = false
    try {
      wizard.doAction(new Purify("Purify"), enemy.get)
    } catch {
      case e: InvalidActionException => exceptionThrown = true
    }
    assertEquals(exceptionThrown, true)
    assertEquals(wizard.mana, 24)
    assertEquals(enemy.get.health, 100)

  // Edge case tests
  test("A wizard with exactly the mana needed can cast the spell"):
    val wizard = new BlackWizard("Merlin", 100, 10, 50, Some(new Wand("Wand", 5, 2, None, 30)), Nil, 20)
    assertEquals(wizard.doAction(new Thunder("Thunder"), enemy.get), true)
    assertEquals(wizard.mana, 0)

