package cl.uchile.dcc
package weapons

import cl.uchile.dcc.weapons.common.{Bow, Sword, Dagger}
import cl.uchile.dcc.weapons.magical.{Staff, Wand}
import cl.uchile.dcc.characters.Character
import cl.uchile.dcc.characters.MagicCharacter


/**Tests for the Weapons class*/
class WeaponsTest extends munit.FunSuite {
  test("A weapon can exist without an initial owner"){
    val sword = new Sword( "King's Sword", 30.0, 20.0)
    val wand = new Wand("Small Wand", 20.0, 20.0, 40.0)
    assert(wand.owner.isEmpty)
    assert(sword.owner.isEmpty)
  }

}
