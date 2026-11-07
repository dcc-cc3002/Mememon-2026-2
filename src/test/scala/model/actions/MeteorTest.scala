package cl.uchile.dcc
package model.actions

import model.panels.Panel
import model.units.{BlackWizard, Enemy, Knight}
import model.usable.Staff

class MeteorTest extends munit.FunSuite:
  var meteor: Option[ActionContract] = None
  var wizard: Option[BlackWizard] = None

  override def beforeEach(context: BeforeEach): Unit = {
    meteor = Some(new Meteor("Meteoroo"))
    wizard = Some(new BlackWizard("Merlin", 100, 10, 50, Some(new Staff("El poderoso", 10, 8, None, 40)), Nil, 100))
  }

  // Partition tests
  test("Meteor damages every unit in the panel and costs 50 mana"):
    val enemy = new Enemy("Goblin", 100, 25, 10, 40)
    val knight = new Knight("Juan", 100, 10, 50, None, Nil)
    val panel = new Panel(0, 0, List(enemy, knight))
    assertEquals(wizard.get.doAction(meteor.get, panel), true)
    assertEquals(enemy.health, 60)
    assertEquals(knight.health, 60)
    assertEquals(wizard.get.mana, 50)

  test("Meteor cannot target a unit"):
    val enemy = new Enemy("Goblin", 100, 25, 10, 40)
    assertEquals(wizard.get.doAction(meteor.get, enemy), false)
    assertEquals(enemy.health, 100)
    assertEquals(wizard.get.mana, 100)

  test("Only a black wizard can cast Meteor"):
    val knight = new Knight("Juan", 100, 10, 50, None, Nil)
    assertEquals(knight.doAction(meteor.get, new Panel(0, 0, Nil)), false)

  // Edge case tests
  test("Meteor on an empty panel succeeds"):
    assertEquals(wizard.get.doAction(meteor.get, new Panel(0, 0, Nil)), true)
    assertEquals(wizard.get.mana, 50)

