package cl.uchile.dcc
package ExceptionsTest

import Actions.{consumePotion, thunder}
import Exceptions.{invalidPotionException, invalidSpellException}
import Items.ManaPotion
import Units.{Knight, WhiteWizard, enemy}

import munit.FunSuite

class invalidSpellExceptionTest extends FunSuite{
  test("invalidSpellException works"){
    val JustSomeWhiteWizard = new WhiteWizard(10,10,10,10)
    val myTarget = new enemy(10,10,10,10)
    val ThunderStruck = new thunder()
    val exception = intercept[invalidSpellException]{
      JustSomeWhiteWizard.doAction(myTarget,ThunderStruck)
    }
    assertEquals(exception.getMessage,"this unit cannot cast doThunder")
  }
}
