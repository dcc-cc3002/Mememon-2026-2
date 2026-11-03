package cl.uchile.dcc
package models
import scala.compiletime.uninitialized
import munit.FunSuite

class EquipActionTest extends FunSuite {

  var knight: Knight = uninitialized
  var enemy: Enemy = uninitialized
  var sword: Sword = uninitialized
  var equipAction: EquipAction = uninitialized

  override def beforeEach(context: BeforeEach): Unit = {
    knight = new Knight("tung tung sahur", hp = 100, defense = 10, weight = 50)
    enemy = new Enemy("brr brr patapim", initialHp = 50, defense = 5, weight = 30, attack = 20)
    sword = new Sword("triple t excalibur", attackPoints = 30, weaponWeight = 10, owner = knight)

    // We pass the weapon we want to equip into the action
    equipAction = new EquipAction(sword)
    knight.availableActions = List(new AttackAction(), equipAction)
  }

  test("1. A character equips a weapon successfully (Returns true)") {
    val success = knight.doAction(equipAction, knight) // The character targets themselves

    assert(success, "Equipping a valid weapon to oneself should return true")
    assertEquals(knight.equippedWeapon, Some(sword), "The character's equipped weapon was not updated")
  }

  test("2. Equipping a weapon to an enemy fails (Returns false)") {
    val success = knight.doAction(equipAction, enemy)

    assert(!success, "Trying to equip a weapon to an enemy should return false")
  }
}