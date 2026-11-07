package cl.uchile.dcc
package ExceptionsTest

import Actions.{equipWeapon, purification}
import Exceptions.notEnoughManaException
import Items.Staff
import Units.{WhiteWizard, enemy}

import munit.FunSuite

class notEnoughManaExceptionTest extends FunSuite {

  test("notEnoughManaException works"){
    val WhiteDude = new WhiteWizard(10, 10, 10, 10)
    val SomeBow = new Staff(10, 10,WhiteDude,10)
    val equip = new equipWeapon()
    val RandomEnemy = new enemy(10, 10, 10, 10)
    val puri = new purification()
    WhiteDude.doAction(SomeBow, equip)
    val exception = intercept[notEnoughManaException]{
      WhiteDude.doAction(RandomEnemy,puri)
    }
  }
}
