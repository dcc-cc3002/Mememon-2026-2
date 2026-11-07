package cl.uchile.dcc
package model.players

import model.units.{Character, EnemiesContract, Enemy, Knight}

class PlayerContractTest extends munit.FunSuite:
  var aliveKnight: Option[Character] = None
  var aliveEnemy: Option[EnemiesContract] = None
  var deadKnight: Option[Character] = None
  var deadEnemy: Option[EnemiesContract] = None

  override def beforeEach(context: BeforeEach): Unit = {
    aliveKnight = Some(new Knight("Juan", 90, 10, 55, None, Nil))
    aliveEnemy = Some(new Enemy("Pedro", 50, 20, 10, 40))
    deadKnight = Some(new Knight("Diego", 0, 10, 55, None, Nil))
    deadEnemy = Some(new Enemy("Jose", 0, 20, 10, 40))
  }

  //Test de las particiones
  test("Player fulfills the PlayerContract contract"):
    val player: PlayerContract = new Player(List(aliveKnight.get, aliveEnemy.get))
    assertEquals(player.units, List(aliveKnight.get, aliveEnemy.get))

  test("Player is not defeated when all its units are alive"):
    val player: PlayerContract = new Player(List(aliveKnight.get, aliveEnemy.get))
    assertEquals(player.defeated(), false)

  test("Player is defeated when all its units have 0 health"):
    val player: PlayerContract = new Player(List(deadKnight.get, deadEnemy.get))
    assertEquals(player.defeated(), true)

  //Test de los casos limite
  test("Player is not defeated when at least one unit is alive"):
    val player: PlayerContract = new Player(List(deadKnight.get, aliveEnemy.get))
    assertEquals(player.defeated(), false)

  test("Player is not defeated when its only unit has 1 health"):
    val player: PlayerContract = new Player(List(new Knight("Juan", 1, 10, 55, None, Nil)))
    assertEquals(player.defeated(), false)

  test("Player is defeated when its units have negative health"):
    val player: PlayerContract = new Player(List(new Enemy("Jose", -5, 20, 10, 40)))
    assertEquals(player.defeated(), true)

  test("Player with no units is defeated"):
    val player: PlayerContract = new Player(Nil)
    assertEquals(player.units, Nil)
    assertEquals(player.defeated(), true)
