package cl.uchile.dcc
package models

import scala.compiletime.uninitialized
import munit.FunSuite


class AttackActionTest extends FunSuite {

  // Variables to be used across all tests
  var knight: Knight = uninitialized
  var otherKnight: Knight = uninitialized
  var enemy: Enemy = uninitialized
  var sword: Sword = uninitialized
  var attackAction: AttackAction = uninitialized

  // This runs before EACH test to ensure HP and states are fully reset
  override def beforeEach(context: BeforeEach): Unit = {
    knight = new Knight("knight", hp = 100, defense = 10, weight = 50)
    otherKnight = new Knight("MegaKnight", hp = 100, defense = 10, weight = 50)

    // Enemy has 20 base attack and 5 defense
    enemy = new Enemy("gigantGoblin", initialHp = 50, defense = 5, weight = 30, attack = 20)

    // Sword with 30 attack points
    sword = new Sword("Excalibur", attackPoints = 30, weaponWeight = 10, owner = knight)

    attackAction = new AttackAction()
  }

  test("1. A character with an equipped weapon attacks an enemy (Success)") {
    knight.equippedWeapon = Some(sword)

    // Expected damage: 30 (sword) - 5 (enemy defense) = 25 damage
    // Enemy HP: 50 - 25 = 25

    val success = knight.doAction(attackAction, enemy)

    assert(success, "The action should return true upon a successful attack")
    assertEquals(enemy.hp, 25, "The enemy's HP did not decrease as expected")
  }

  test("2. An enemy attacks a character (Success)") {
    // Expected damage: 20 (enemy attack) - 10 (character defense) = 10 damage
    // Character HP: 100 - 10 = 90

    val success = enemy.doAction(attackAction, knight)

    assert(success, "The action should return true upon a successful attack")
    assertEquals(knight.hp, 90, "The character's HP did not decrease as expected")
  }

  test("3. Friendly fire between characters fails (Returns false)") {
    val success = knight.doAction(attackAction, otherKnight)

    assert(!success, "Friendly fire must return false")
    assertEquals(otherKnight.hp, 100, "The target character should not receive damage from an ally")
  }

  test("4. Attacking a dead enemy fails (Returns false)") {
    enemy.hp = 0 // Manually set enemy HP to 0 to simulate death
    knight.equippedWeapon = Some(sword)

    val success = knight.doAction(attackAction, enemy)

    assert(!success, "Attacking an already dead target must return false")
  }
}