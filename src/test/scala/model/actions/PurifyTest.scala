package cl.uchile.dcc
package model.actions

import model.panels.Panel
import model.units.{BlackWizard, Enemy, Knight, WhiteWizard}
import model.usable.Wand

class PurifyTest extends munit.FunSuite:
  var purify: Option[ActionContract] = None
  var wizard: Option[WhiteWizard] = None
  var enemy: Option[Enemy] = None

  override def beforeEach(context: BeforeEach): Unit = {
    purify = Some(new Purify("Purificador"))
    wizard = Some(new WhiteWizard("Gandalf", 100, 10, 50, Some(new Wand("Wand", 5, 2, None, 20)), Nil, 100))
    enemy = Some(new Enemy("Goblin", 100, 25, 10, 40))
  }

  // Partition tests
  test("Purify removes 15% of the current health plus magicDamage / 2 and costs 25 mana"):
    assertEquals(wizard.get.doAction(purify.get, enemy.get), true)
    assertEquals(enemy.get.health, 75)
    assertEquals(wizard.get.mana, 75)

  test("Purify uses the current health, not the maximum"):
    enemy.get.takeDamage(60)
    wizard.get.doAction(purify.get, enemy.get)
    assertEquals(enemy.get.health, 24)

  test("Purify cannot target a character"):
    val knight = new Knight("Juan", 100, 10, 50, None, Nil)
    assertEquals(wizard.get.doAction(purify.get, knight), false)
    assertEquals(knight.health, 100)
    assertEquals(wizard.get.mana, 100)

  test("Purify cannot target a panel"):
    assertEquals(wizard.get.doAction(purify.get, new Panel(0, 0, Nil)), false)

  test("Only a white wizard can cast Purify"):
    val blackWizard = new BlackWizard("Merlin", 100, 10, 50, None, Nil, 100)
    assertEquals(blackWizard.doAction(purify.get, enemy.get), false)
    assertEquals(enemy.get.health, 100)

