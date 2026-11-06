package cl.uchile.dcc
package model.actions

import model.panels.Panel
import model.units.{BlackWizard, Enemy, Knight}
import model.usable.{FortitudePotion, HealingPotion, MagicStrengthPotion, ManaPotion, Wand}

class ConsumePotionTest extends munit.FunSuite:
  var thunder: Option[ActionContract] = None
  var meteor: Option[ActionContract] = None

  override def beforeEach(context: BeforeEach): Unit = {
    thunder = Some(new Thunder("Rayooo"))
    meteor = Some(new Meteor("Meteoritooo"))
  }

  // Partition tests
  test("A healing potion restores 20% of the maximum health and leaves the inventory"):
    val potion = new HealingPotion("Cura")
    val knight = new Knight("Juan", 100, 10, 50, None, List(potion))
    knight.takeDamage(50)
    assertEquals(knight.doAction(new ConsumePotion("Pepsi", List(potion)), knight), true)
    assertEquals(knight.health, 70)
    assertEquals(knight.utilities, Nil)

  test("A fortitude potion increases the defense by 15%"):
    val potion = new FortitudePotion("Fortitude")
    val knight = new Knight("Juan", 100, 20, 50, None, List(potion))
    assertEquals(knight.doAction(new ConsumePotion("Pepsi", List(potion)), knight), true)
    assertEquals(knight.defense, 23)

  test("A mana potion restores 30% of the maximum mana of a magic character"):
    val potion = new ManaPotion("Mana")
    val wizard = new BlackWizard("Merlin", 100, 10, 50, None, List(potion), 100)
    wizard.doAction(meteor.get, new Panel(9, 9, Nil))
    assertEquals(wizard.mana, 50)
    assertEquals(wizard.doAction(new ConsumePotion("Pepsi", List(potion)), wizard), true)
    assertEquals(wizard.mana, 80)

  test("A magic strength potion increases the damage of the next spell only"):
    val potion = new MagicStrengthPotion("Strength")
    val wizard = new BlackWizard("Merlin", 100, 10, 50, Some(new Wand("Wand", 5, 2, None, 40)), List(potion), 100)
    val enemy = new Enemy("Goblin", 200, 25, 10, 40)
    assertEquals(wizard.doAction(new ConsumePotion("Pepsi", List(potion)), wizard), true)
    wizard.doAction(thunder.get, enemy)
    assertEquals(enemy.health, 140)
    wizard.doAction(thunder.get, enemy)
    assertEquals(enemy.health, 100)

  test("A magic potion has no effect on a common character and stays in the inventory"):
    val potion = new ManaPotion("Mana")
    val knight = new Knight("Juan", 100, 10, 50, None, List(potion))
    assertEquals(knight.doAction(new ConsumePotion("Pepsi", List(potion)), knight), false)
    assertEquals(knight.utilities, List(potion))

  test("An enemy cannot consume a potion"):
    val enemy = new Enemy("Goblin", 100, 25, 10, 40)
    assertEquals(enemy.doAction(new ConsumePotion("Pepsi", List(new HealingPotion("Cura"))), enemy), false)

  // Edge case tests
  test("A healing potion does not go above the maximum health"):
    val potion = new HealingPotion("Cura")
    val knight = new Knight("Juan", 100, 10, 50, None, List(potion))
    knight.takeDamage(5)
    knight.doAction(new ConsumePotion("Pepsi", List(potion)), knight)
    assertEquals(knight.health, 100)

  test("A mana potion does not go above the maximum mana"):
    val potion = new ManaPotion("Mana")
    val wizard = new BlackWizard("Merlin", 100, 10, 50, None, List(potion), 100)
    wizard.doAction(new ConsumePotion("Pepsi", List(potion)), wizard)
    assertEquals(wizard.mana, 100)

  test("A character cannot consume a potion that is not in its inventory"):
    val knight = new Knight("Juan", 100, 10, 50, None, Nil)
    knight.takeDamage(50)
    assertEquals(knight.doAction(new ConsumePotion("Pepsi", List(new HealingPotion("Cura"))), knight), false)
    assertEquals(knight.health, 50)

  test("A character cannot give a potion to another character"):
    val potion = new HealingPotion("Cura")
    val knight = new Knight("Juan", 100, 10, 50, None, List(potion))
    val other = new Knight("Pedro", 100, 10, 50, None, List(potion))
    assertEquals(knight.doAction(new ConsumePotion("Pepsi", List(potion)), other), false)

  test("Only one copy of a repeated potion is consumed"):
    val potion = new HealingPotion("Cura")
    val knight = new Knight("Juan", 100, 10, 50, None, List(potion, potion))
    knight.doAction(new ConsumePotion("Pepsi", List(potion)), knight)
    assertEquals(knight.utilities, List(potion))

