package cl.uchile.dcc
package ExceptionsTest

import cl.uchile.dcc.Actions.{equipWeapon, purification}
import cl.uchile.dcc.Exceptions.invalidWeaponToSpellException
import cl.uchile.dcc.Items.{Bow, Sword}
import cl.uchile.dcc.Units.{WhiteWizard, enemy}
import munit.FunSuite

class invalidWeaponToSpellExceptionTest extends FunSuite{
  test("invalidWeaponToSpellException works"){
    val WhiteDude = new WhiteWizard(10,10,10,10)
    val SomeBow = new Bow(10,10,WhiteDude)
    val equip = new equipWeapon()
    val RandomEnemy = new enemy(10,10,10,10)
    val puri = new purification()
    WhiteDude.doAction(SomeBow,equip)
    val exception = intercept[invalidWeaponToSpellException]{
      WhiteDude.doAction(RandomEnemy,puri)
    }
  }
}
