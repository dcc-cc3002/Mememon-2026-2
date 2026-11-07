package cl.uchile.dcc
package ExceptionsTest

import Actions.attack
import Exceptions.weaponUnequippedException
import Units.{Knight, enemy}

import munit.FunSuite

class weaponUnequippedExceptionTest extends FunSuite{
  test("weaponUnequippedException works"){
    val MyKnight = new Knight(10,10,10)
    val MyEnemy = new enemy(10,10,10,10)
    val atk = new attack()
    val exception = intercept[weaponUnequippedException]{
      MyKnight.doAction(MyEnemy,atk)
    }
  }
}
