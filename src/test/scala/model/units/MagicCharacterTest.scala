package cl.uchile.dcc
package model.units

import model.usable.Wand

class MagicCharacterTest extends munit.FunSuite:
  var bwizard: Option[MagicCharacter] = None
  var wwizard: Option[MagicCharacter] = None

  override def beforeEach(context: BeforeEach): Unit = {
    bwizard = Some(new BlackWizard("Juan", 90, 10, 55, None, List("potion"), 5))
    wwizard = Some(new WhiteWizard("Matias", 80, 5, 60, None, List("potion"), 6))
  }

  test("BlackWizard fulfills the MagicCharacter contract"):
    val b = bwizard.get
    assertEquals(b.name, "Juan")
    assertEquals(b.health, 90)
    assertEquals(b.defense, 10)
    assertEquals(b.weight, 55)
    assertEquals(b.weapon, None)
    assertEquals(b.utilities, List("potion"))
    assertEquals(b.mana, 5)

  test("WhiteWizard fulfills the MagicCharacter contract"):
    val w = wwizard.get
    assertEquals(w.name, "Matias")
    assertEquals(w.health, 80)
    assertEquals(w.defense, 5)
    assertEquals(w.weight, 60)
    assertEquals(w.weapon, None)
    assertEquals(w.utilities, List("potion"))
    assertEquals(w.mana, 6)

  test("maxActionBar of a MagicCharacter with weapon is its weight plus half the weapon weight"):
    val wand = new Wand("Varita", 5, 20, None, 30)
    val armedWizard: MagicCharacter = new BlackWizard("Juan", 90, 10, 55, Some(wand), Nil, 5)
    assertEquals(armedWizard.maxActionBar, 65.0)

