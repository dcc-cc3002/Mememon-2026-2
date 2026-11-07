package cl.uchile.dcc
package player

import scala.collection.mutable.ArrayBuffer
import cl.uchile.dcc.unit.GameUnit
import cl.uchile.dcc.player.Player
import cl.uchile.dcc.characters.commoncharacters.{Archer, Knight, Thief}
import cl.uchile.dcc.characters.magiccharacters.{BlackMage, WhiteMage}
import cl.uchile.dcc.enemy.Enemy

/**Tests for Player class*/

class PlayerTest extends munit.FunSuite {
  test("Creates a player with an empty list of units to start"){
    val player = new Player("Player 1")
    assertEquals(player.name, "Player 1")
    assert(player.getUnits.isEmpty)
  }

  test("A player can add units to their empty list") {
    val archer = new Archer("Colin", 100.0, 100.0, 80.0, 80.0)
    val gorgon = new Enemy("Gorgon", 120.0, 120.0,100.0, 80.0, 40.0)
    val player = new Player("Player 1")
    player.addUnit(archer)
    assertEquals(player.getUnits, List[GameUnit](archer))
    assert(!player.isDefeated)

    player.addUnit(gorgon)
    assertEquals(player.getUnits, List(archer, gorgon))
    assert(!player.isDefeated)
  }

}
