package cl.uchile.dcc
package PlayersTest

import Players.player

import munit.FunSuite



class playerTest extends FunSuite {
  test("Player init works") {
    val PlayerTest = new player("Faker")
    assertEquals(PlayerTest.Name, "Faker")
    assertEquals(PlayerTest.getUnitsList, List.empty)
    assert(!PlayerTest.isDefeated)
  }
}