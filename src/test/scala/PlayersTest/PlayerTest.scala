package cl.uchile.dcc
package PlayersTest

import Players.Player

import munit.FunSuite



class PlayerTest extends FunSuite{
  test("Player init works"){
    val PlayerTest = new Player("Faker")
    assertEquals(PlayerTest.Name,"Faker") //Implementations will have access to attributes like defeated or UnitsList to avoid showing too much to the client

  }
}
