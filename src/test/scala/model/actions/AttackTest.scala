package cl.uchile.dcc
package model.actions

import model.panels.Panel
import model.units.{Enemy, Knight}
import model.usable.Sword

class AttackTest extends munit.FunSuite:
  var attack: Option[ActionContract] = None
  var knight: Option[Knight] = None
  var enemy: Option[Enemy] = None

  override def beforeEach(context: BeforeEach): Unit = {
    attack = Some(new Attack("Attack"))
    knight = Some(new Knight("Juan", 100, 10, 50, Some(new Sword("Sword", 30, 10, None)), Nil))
    enemy = Some(new Enemy("Pedro", 100, 25, 10, 40))
  }

  // Partition tests
  test("A character with a weapon deals the weapon attack minus the target defense"):
    assertEquals(knight.get.doAction(attack.get, enemy.get), true)
    assertEquals(enemy.get.health, 80)

  test("An enemy deals its own attack minus the target defense"):
    assertEquals(enemy.get.doAction(attack.get, knight.get), true)
    assertEquals(knight.get.health, 85)

  test("A character without a weapon cannot attack"):
    val unarmed = new Knight("Pedro", 100, 10, 50, None, Nil)
    assertEquals(unarmed.doAction(attack.get, enemy.get), false)
    assertEquals(enemy.get.health, 100)

  test("A panel cannot be attacked"):
    assertEquals(knight.get.doAction(attack.get, new Panel(0, 0, Nil)), false)

  // Edge case tests
  test("An attack weaker than the defense deals no damage"):
    val weak = new Enemy("Rat", 100, 5, 10, 10)
    assertEquals(weak.doAction(attack.get, knight.get), true)
    assertEquals(knight.get.health, 100)

  test("Health never goes below 0"):
    val strong = new Enemy("Dragon", 100, 500, 10, 10)
    strong.doAction(attack.get, knight.get)
    assertEquals(knight.get.health, 0)

