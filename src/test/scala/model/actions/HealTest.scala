package cl.uchile.dcc
package model.actions

import model.panels.Panel
import model.units.{BlackWizard, Enemy, Knight, WhiteWizard}
import model.usable.Wand

class HealTest extends munit.FunSuite:
  var heal: Option[ActionContract] = None
  var wizard: Option[WhiteWizard] = None
  var knight: Option[Knight] = None

  override def beforeEach(context: BeforeEach): Unit = {
    heal = Some(new Heal("Heal"))
    wizard = Some(new WhiteWizard("Gandalf", 100, 10, 50, Some(new Wand("Wand", 5, 2, None, 20)), Nil, 100))
    knight = Some(new Knight("Juan", 100, 10, 50, None, Nil))
  }

  // Partition tests
  test("Heal restores 20% of the maximum health plus magicDamage / 4 and costs 15 mana"):
    knight.get.takeDamage(50)
    assertEquals(wizard.get.doAction(heal.get, knight.get), true)
    assertEquals(knight.get.health, 75)
    assertEquals(wizard.get.mana, 85)

  test("Heal cannot target an enemy"):
    val enemy = new Enemy("Goblin", 100, 25, 10, 40)
    enemy.takeDamage(50)
    assertEquals(wizard.get.doAction(heal.get, enemy), false)
    assertEquals(enemy.health, 50)
    assertEquals(wizard.get.mana, 100)

  test("Heal cannot target a panel"):
    assertEquals(wizard.get.doAction(heal.get, new Panel(0, 0, Nil)), false)

  test("Only a white wizard can cast Heal"):
    val blackWizard = new BlackWizard("Merlin", 100, 10, 50, None, Nil, 100)
    knight.get.takeDamage(50)
    assertEquals(blackWizard.doAction(heal.get, knight.get), false)
    assertEquals(knight.get.health, 50)


