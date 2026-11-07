package cl.uchile.dcc
package model.usable

import model.units.{Character, Knight}
import model.usable.*

class MagicWeaponTest extends munit.FunSuite:
  var knight: Option[Character] = None
  var wand: Option[MagicWeapon] = None
  var staff: Option[MagicWeapon] = None

  override def beforeEach(context: BeforeEach): Unit = {
    wand = Some(new Wand("Elder Wand", 10, 1, None, 40))
    knight = Some(new Knight("Juan", 90, 10, 55, wand, Nil))
    staff = Some(new Staff("Oak Staff", 15, 5, knight, 25))
  }

  test("Wand fulfills the MagicWeapon contract"):
    val w = wand.get
    assertEquals(w.name, "Elder Wand")
    assertEquals(w.attack, 10)
    assertEquals(w.weight, 1)
    assertEquals(w.owner, None)
    assertEquals(w.magicAttack, 40)

  test("Staff fulfills the MagicWeapon contract"):
    val s = staff.get
    assertEquals(s.name, "Oak Staff")
    assertEquals(s.attack, 15)
    assertEquals(s.weight, 5)
    assertEquals(s.owner, knight)
    assertEquals(s.magicAttack, 25)