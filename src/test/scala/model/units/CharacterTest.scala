package cl.uchile.dcc
package model.units

import model.usable.{Bow, HealingPotion, ManaPotion, Sword}

class CharacterTest extends munit.FunSuite:
  var knight: Option[Character] = None
  var archer: Option[Character] = None
  var thief: Option[Character] = None
  val healingPotion = new HealingPotion("Healing")
  val manaPotion = new ManaPotion("Mana")
  val bow = new Bow("Long Bow", 10, 5, None)

  override def beforeEach(context: BeforeEach): Unit = {
    knight = Some(new Knight("Juan", 90, 10, 55, None, List(healingPotion)))
    archer = Some(new Archer("Pedro", 92, 13, 54, None, List(healingPotion, bow)))
    thief = Some(new Thief("Diego", 80, 5, 30, None, List(manaPotion)))
  }

  test("Knight fulfills the Character contract"):
    val k = knight.get
    assertEquals(k.name, "Juan")
    assertEquals(k.health, 90)
    assertEquals(k.defense, 10)
    assertEquals(k.weight, 55)
    assertEquals(k.weapon, None)
    assertEquals(k.utilities, List(healingPotion))

  test("Archer fulfills the Character contract"):
    val a = archer.get
    assertEquals(a.name, "Pedro")
    assertEquals(a.health, 92)
    assertEquals(a.defense, 13)
    assertEquals(a.weight, 54)
    assertEquals(a.weapon, None)
    assertEquals(a.utilities, List(healingPotion, bow))

  test("Thief fulfills the Character contract"):
    val t = thief.get
    assertEquals(t.name, "Diego")
    assertEquals(t.health, 80)
    assertEquals(t.defense, 5)
    assertEquals(t.weight, 30)
    assertEquals(t.weapon, None)
    assertEquals(t.utilities, List(manaPotion))

  test("maxActionBar of a Character without weapon is its weight"):
    assertEquals(knight.get.maxActionBar, 55.0)

  test("maxActionBar of a Character with weapon is its weight plus half the weapon weight"):
    val sword = new Sword("Excalibur", 10, 10, None)
    val armedKnight: Character = new Knight("Juan", 90, 10, 55, Some(sword), Nil)
    assertEquals(armedKnight.maxActionBar, 60.0)

  test("maxActionBar of a Character with an odd weapon weight keeps the decimal"):
    val sword = new Sword("Excalibur", 10, 5, None)
    val armedKnight: Character = new Knight("Juan", 90, 10, 55, Some(sword), Nil)
    assertEquals(armedKnight.maxActionBar, 57.5)










