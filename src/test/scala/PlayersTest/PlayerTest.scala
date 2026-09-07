package cl.uchile.dcc
package PlayersTest

import cl.uchile.dcc.Players.Player
import munit.FunSuite

import scala.collection.mutable.ListBuffer

class PlayerTest extends FunSuite{
  test("Player init works"){
    val PlayerTest = new Player("Faker")
    assertEquals(PlayerTest.Name,"Faker")
    assertEquals(PlayerTest.Defeated,false)
    assertEquals(PlayerTest.Units,ListBuffer())
  }
}
