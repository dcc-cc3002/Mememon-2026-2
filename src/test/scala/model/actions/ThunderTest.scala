package cl.uchile.dcc
package model.actions

import model.panels.Panel
import model.units.{BlackWizard, Enemy, Knight, WhiteWizard}
import model.usable.Wand

class ThunderTest extends munit.FunSuite:
  var thunder: Option[ActionContract] = None
  var wizard: Option[BlackWizard] = None
  var enemy: Option[Enemy] = None

  override def beforeEach(context: BeforeEach): Unit = {
    thunder = Some(new Thunder("Truenooo"))
    wizard = Some(new BlackWizard("Merlin", 100, 10, 50, Some(new Wand("Wand", 5, 2, None, 30)), Nil, 100))
    enemy = Some(new Enemy("Goblin", 100, 25, 10, 40))
  }

  // Partition tests
  test("Thunder deals the magic damage of the weapon, ignoring defense, and costs 20 mana"):
    assertEquals(wizard.get.doAction(thunder.get, enemy.get), true)
    assertEquals(enemy.get.health, 70)
    assertEquals(wizard.get.mana, 80)

  test("Thunder can target a character"):
    val knight = new Knight("Juan", 100, 10, 50, None, Nil)
    assertEquals(wizard.get.doAction(thunder.get, knight), true)
    assertEquals(knight.health, 70)

  test("Only a black wizard can cast Thunder"):
    val whiteWizard = new WhiteWizard("Gandalf", 100, 10, 50, None, Nil, 100)
    val knight = new Knight("Juan", 100, 10, 50, None, Nil)
    assertEquals(whiteWizard.doAction(thunder.get, enemy.get), false)
    assertEquals(knight.doAction(thunder.get, enemy.get), false)
    assertEquals(enemy.get.doAction(thunder.get, knight), false)
    assertEquals(enemy.get.health, 100)

  test("Thunder cannot target a panel and does not spend mana"):
    assertEquals(wizard.get.doAction(thunder.get, new Panel(0, 0, Nil)), false)
    assertEquals(wizard.get.mana, 100)

  // Edge case tests
  test("Thunder fails without enough mana"):
    val tired = new BlackWizard("Merlin", 100, 10, 50, None, Nil, 19)
    assertEquals(tired.doAction(thunder.get, enemy.get), false)
    assertEquals(tired.mana, 19)

  test("Thunder without a magic weapon deals no damage"):
    val unarmed = new BlackWizard("Merlin", 100, 10, 50, None, Nil, 100)
    assertEquals(unarmed.doAction(thunder.get, enemy.get), true)
    assertEquals(enemy.get.health, 100)

