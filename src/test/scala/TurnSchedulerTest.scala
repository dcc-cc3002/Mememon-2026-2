package cl.uchile.dcc

import munit.FunSuite
import character_units.characters.*
import items.weapons.Bow


class TurnSchedulerTest extends FunSuite{

  var knight: Knight = _
  var archer: Archer = _
  var white_mage: WhiteMage = _
  var bow : Bow = _
  
  override def beforeEach(context: BeforeEach): Unit ={
    bow = new Bow("Bow Name", 10, 2, None, false)
    knight = new Knight("Knight Name", 20, 5, 5, false, None, List())
    archer = new Archer("Archer Name", 15, 3, 3, false, Some(bow), List())
    white_mage = new WhiteMage("White Mage Name", 10, 2, 2, true, None, List())


  }
  
  test("TS adds characters correctly") {
    val ts = new TurnScheduler()
    ts.addCharacter(knight)
    ts.addCharacter(archer)
    ts.addCharacter(white_mage)

    assertEquals(ts.characters.length, 3)
    assert(ts.characters.contains(knight))
    assert(ts.characters.contains(archer))
    assert(ts.characters.contains(white_mage))
  }
  
  test("TS removes characters correctly") {
    val ts = new TurnScheduler()
    ts.addCharacter(knight)
    ts.addCharacter(archer)
    ts.addCharacter(white_mage)

    ts.removeCharacter(archer)
    assertEquals(ts.characters.length, 2)
    assert(ts.characters.contains(knight))
    assert(!ts.characters.contains(archer))
    assert(ts.characters.contains(white_mage))

    ts.removeCharacter(knight)
    ts.removeCharacter(white_mage)
    assertEquals(ts.characters.length, 0)

    ts.removeCharacter(knight)

  }

  test("TS calculates all characters max action bar correctly") {
    val ts = new TurnScheduler()
    ts.addCharacter(knight)
    ts.addCharacter(archer)
    ts.addCharacter(white_mage)

    val knightMaxActionBar = 5
    val archerMaxActionBar = 4
    val whiteMageMaxActionBar = 2

    val expected = Map[Character, Float](
      knight -> knightMaxActionBar,
      archer -> archerMaxActionBar,
      white_mage -> whiteMageMaxActionBar
    )
    assertEquals(ts.maxActionBars, expected)
  }

  test("TS calculates all characters current action bar correctly") {
    val ts = new TurnScheduler()
    ts.addCharacter(knight)
    ts.addCharacter(archer)
    ts.addCharacter(white_mage)

    knight.actionBar = 3
    archer.actionBar = 2
    white_mage.actionBar = 1

    val expected = Map[Character, Float](
      knight -> 3,
      archer -> 2,
      white_mage -> 1
    )
    assertEquals(ts.currentActionBars, expected)
  }

  test("TS adds a value to every action bar correctly") {
    val ts = new TurnScheduler()
    ts.addCharacter(knight)
    ts.addCharacter(archer)
    ts.addCharacter(white_mage)

    knight.actionBar = 3
    archer.actionBar = 2
    white_mage.actionBar = 1

    val valueToAdd: Float = 1.5
    val expected = Map[Character, Float](
      knight -> (3 + valueToAdd),
      archer -> (2 + valueToAdd),
      white_mage -> (1 + valueToAdd)
    )

    ts.addToAll(valueToAdd)

    assertEquals(ts.currentActionBars, expected)
  }


  test("TS returns characters wich action bar is greater than or equal to their max action bar") {
    val ts = new TurnScheduler()
    ts.addCharacter(knight)
    ts.addCharacter(archer)
    ts.addCharacter(white_mage)

    knight.actionBar = 5
    archer.actionBar = 4
    white_mage.actionBar = 1

    val expected = List(knight, archer)

    val result = ts.completed()

    assertEquals(result.sortBy(-_.actionBar), expected.sortBy(-_.actionBar))
  }

  test("TS resets a list of character's action bar to 0") {
    val ts = new TurnScheduler()
    ts.addCharacter(knight)
    ts.addCharacter(archer)
    ts.addCharacter(white_mage)

    knight.actionBar = 5.0f
    archer.actionBar = 4.0f
    white_mage.actionBar = 1.0f

    val completedCharacters = ts.completed()

    ts.resetActionBars(completedCharacters)

    assertEquals(knight.actionBar, 0.0f)
    assertEquals(archer.actionBar, 0.0f)
    assertEquals(white_mage.actionBar, 1.0f)
  }

  test("TS orders the list of completed characters by the difference between their action bar and their max action bar") {
    val ts = new TurnScheduler()
    ts.addCharacter(knight)
    ts.addCharacter(archer)
    ts.addCharacter(white_mage)

    knight.actionBar = 5.0f // max is 5
    archer.actionBar = 5.0f // max is 4
    white_mage.actionBar = 5.0f // max is 2

    var completedCharacters = ts.completed()
    completedCharacters = ts.turnOrder(completedCharacters)

    val expectedOrder = List(white_mage, archer, knight)

    assertEquals(completedCharacters, expectedOrder)
  }
  
  
}
