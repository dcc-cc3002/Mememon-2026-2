package cl.uchile.dcc
package model.usable

import model.units.{Character, Knight}
import model.usable.*

class WeaponTest extends munit.FunSuite:
  var knight: Option[Character] = None
  var sword: Option[Weapon] = None
  var dagger: Option[Weapon] = None
  var bow: Option[Weapon] = None

  override def beforeEach(context: BeforeEach): Unit = {
    sword = Some(new Sword("Excalibur", 30, 8, None))
    knight = Some(new Knight("Juan", 90, 10, 55, sword, Nil))
    dagger = Some(new Dagger("Shiv", 12, 2, knight))
    bow = Some(new Bow("Longbow", 20, 4, knight))
  }

  test("Sword fulfills the Weapon contract"):
    val s = sword.get
    assertEquals(s.name, "Excalibur")
    assertEquals(s.attack, 30)
    assertEquals(s.weight, 8)
    assertEquals(s.owner, None)

  test("Dagger fulfills the Weapon contract"):
    val d = dagger.get
    assertEquals(d.name, "Shiv")
    assertEquals(d.attack, 12)
    assertEquals(d.weight, 2)
    assertEquals(d.owner, knight)

  test("Bow fulfills the Weapon contract"):
    val b = bow.get
    assertEquals(b.name, "Longbow")
    assertEquals(b.attack, 20)
    assertEquals(b.weight, 4)
    assertEquals(b.owner, knight)


