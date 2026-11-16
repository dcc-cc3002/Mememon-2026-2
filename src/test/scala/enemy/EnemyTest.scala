package cl.uchile.dcc
package enemy

import cl.uchile.dcc.enemy.Enemy

/** Test to verify the Enemy class and its
 * characteristics
 * */

class EnemyTest extends munit.FunSuite {
  test("an enemy exists with its attributes"){
    val harpy = new Enemy("Harpy", 80.0, 80.0, 50.0, 50.0, 30.0)
    assertEquals(harpy.name, "Harpy")
    assertEquals(harpy.maxHp, 80.0)
    assertEquals(harpy.hp, 80.0)
    assertEquals(harpy.defense, 50.0)
    assertEquals(harpy.weight, 50.0)
    assertEquals(harpy.attack, 30.0)
  }

  test("an enemy can have a lower hp compared to its maxHp") {
    val orc = new Enemy("Orc", 100.0, 100.0, 120.0, 120.0, 100.0)
    orc.hp = 80.0
    assertEquals(orc.hp, 80.0)
    assert(orc.maxHp > orc.hp, true)
  }
}
