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
    knight.equippedWeapon = Some(sword)
    val success = knight.doAction(attackAction, otherKnight)
    assert(!success, "Friendly fire must return false")
    assertEquals(otherKnight.hp, 100, "The target character should not receive damage from an ally")
  }

  test("4. Attacking a dead enemy throws an exception") {
    enemy.hp = 0
    knight.equippedWeapon = Some(sword)
    intercept[IllegalArgumentException] {
      knight.doAction(attackAction, enemy)
    }
  }
  test("Una unidad sin HP no puede realizar un ataque (lanza IllegalArgumentException)") {
    val deadCharacter = new Knight("MegaKnight", hp = 0, defense = 10, weight = 50)
    val targetEnemy = Enemy("gigantGoblin", initialHp = 50, defense = 5, weight = 30, attack = 20)
    val attackAction = new AttackAction()
    intercept[IllegalArgumentException] {
      attackAction.executeByCharacter(deadCharacter, targetEnemy)
    }
  }
  //this is for panel because i didn't have implemented in the latest work
  test("Una unidad no puede moverse a un panel que no es aledaño (lanza IllegalArgumentException)") {
    val panelActual = new Panel(0, 0)
    val panelLejano = new Panel(5, 5) // No es aledaño a (0,0)

    val knight = new Knight("TestKnight", 100, 10, 10)
    knight.currentPanel = Some(panelActual)
    val moveAction = new MoveAction(panelLejano)
    intercept[IllegalArgumentException] {
      moveAction.executeByCharacter(knight, knight)
    }
  }

  //estos son los spells
  test("Curación sobre un enemigo lanza excepción") {
    val mage = new WhiteMagician("magordito", 100, 10, 10, 50)
    mage.equippedWeapon = Some(new Wand("waza", 10, 5, mage, 20))
    val enemy = new Enemy("mono", 100, 10, 10, 10)

    intercept[IllegalArgumentException] {
      new HealAction().executeByCharacter(mage, enemy)
    }
  }

  test("Purificación sobre un personaje aliado lanza excepción") {
    val mage = new WhiteMagician("white spy", 100, 10, 10, 50)
    mage.equippedWeapon = Some(new Wand("sap", 10, 5, mage, 20))
    val ally = new Knight("stark", 100, 10, 10)

    intercept[IllegalArgumentException] {
      new PurifyAction().executeByCharacter(mage, ally)
    }
  }

  test("Lanzar hechizo sin maná lanza excepción") {
    val mage = new WhiteMagician("dobby", 100, 10, 10, 0) // 0 de Maná
    mage.equippedWeapon = Some(new Wand("uña", 10, 5, mage, 20))
    val ally = new Knight("harry", 100, 10, 10)

    intercept[IllegalArgumentException] {
      new HealAction().executeByCharacter(mage, ally)
    }
  }
}