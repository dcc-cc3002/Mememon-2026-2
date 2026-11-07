package cl.uchile.dcc
package ExceptionsTest

import cl.uchile.dcc.Actions.{attack, consumePotion, heal, move, thunder}
import cl.uchile.dcc.Exceptions.{deadException, invalidPotionException}
import cl.uchile.dcc.Items.ManaPotion
import cl.uchile.dcc.Locations.panel
import cl.uchile.dcc.Units.{BlackWizard, Knight, WhiteWizard}
import munit.FunSuite

class deadExceptionsTest extends FunSuite{

  test("deadException works"){
    val DeadKnight = new Knight(-10,10,10)
    val AliveKnight = new Knight(10,10,10)
    val Attack = new attack()
    val exception1 = intercept[deadException]{
      DeadKnight.doAction(AliveKnight,Attack)
    }
    val exception2 = intercept[deadException]{
      AliveKnight.doAction(DeadKnight,Attack)
    }
    assertEquals(exception1.getMessage,"Source unit died before")
    assertEquals(exception2.getMessage,"Target unit died before")
  }

}
