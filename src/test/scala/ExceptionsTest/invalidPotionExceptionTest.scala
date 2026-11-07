package cl.uchile.dcc
package ExceptionsTest

import cl.uchile.dcc.Actions.consumePotion
import cl.uchile.dcc.Exceptions.invalidPotionException
import cl.uchile.dcc.Items.ManaPotion
import cl.uchile.dcc.Units.Knight
import munit.FunSuite

class invalidPotionExceptionTest extends FunSuite{
  test("invalidPotionException works"){
    val JustSomeKnightAgain = new Knight(10,10,10)
    val consume = new consumePotion()
    val magicPotion = new ManaPotion()
    val exception = intercept[invalidPotionException]{
      JustSomeKnightAgain.doAction(magicPotion,consume)
    }
    assertEquals(exception.getMessage,"this character cannot consume magic potions")
  }
}
