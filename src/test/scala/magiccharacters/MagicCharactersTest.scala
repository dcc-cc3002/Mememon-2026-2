package cl.uchile.dcc
package magiccharacters

import scala.collection.mutable.ArrayBuffer
import cl.uchile.dcc.characters.magiccharacters.{BlackMage, WhiteMage}
import cl.uchile.dcc.weapons.Weapon

class MagicCharactersTest extends munit.FunSuite {
  val blackMage = new BlackMage("Bellatrix", 100.0, 100.0, 80.0, 70.0, 100.0, 50.0)
  val whiteMage = new WhiteMage("Ian", 100.0, 100.0, 80.0, 70.0, 100.0, 50.0)

  test("A Magic Character has its attributes defined") {
    assertEquals(blackMage.name, "Bellatrix")
    assertEquals(whiteMage.maxHp, 100.0)
    assertEquals(blackMage.defense, 80.0)
    assertEquals(whiteMage.weight, 70.0)
    assertEquals(blackMage.hp, 100.0)
    assertEquals(whiteMage.maxMana, 100.0)
    assertEquals(blackMage.mana, 50.0)
  }

  test("A magic character can have an inventory and it's empty by default") {
    assert(blackMage.getInventory.isEmpty)
    assert(whiteMage.getInventory.isEmpty)
  }

  test("A magic character can have a slot for a weapon, which is empty by default to start") {
    assert(blackMage.equippedWeapon.isEmpty)
    assert(whiteMage.equippedWeapon.isEmpty)
  }

  test("A magic character can have less Hp points compared to their max") {
    whiteMage.hp = 80.0
    assertEquals(whiteMage.hp, 80.0)
    assert(whiteMage.maxHp > whiteMage.hp)
  }

  test("A magic character can gain more mana points"){
    blackMage.mana += 20.0
    assert(blackMage.mana > 50.0)

  }

}
