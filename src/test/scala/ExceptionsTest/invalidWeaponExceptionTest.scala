package cl.uchile.dcc
package ExceptionsTest

import cl.uchile.dcc.Actions.equipWeapon
import cl.uchile.dcc.Exceptions.invalidWeaponException
import cl.uchile.dcc.Items.Staff
import cl.uchile.dcc.Units.Knight
import munit.FunSuite

class invalidWeaponExceptionTest extends FunSuite{

  test("invalidWeaponException works"){
    val MyKnight = new Knight(10,10,10)
    val equip = new equipWeapon()
    val MyStaff = new Staff(10,10,MyKnight,10)
    val exception = intercept[invalidWeaponException]{
      MyKnight.doAction(MyStaff,equip)
    }
  }

}
