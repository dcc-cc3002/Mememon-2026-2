package cl.uchile.dcc
package ExceptionsTest

import cl.uchile.dcc.Actions.{attack, equipWeapon}
import cl.uchile.dcc.Exceptions.invalidInputException
import cl.uchile.dcc.Items.{ManaPotion, Sword}
import cl.uchile.dcc.Units.{Knight, Thief}
import munit.FunSuite

class invalidInputExceptionTest extends FunSuite{

  test("invalidInputException works"){
    val MyKnight = new Knight(10,10,10)
    val MyItem = new ManaPotion()
    val RandomWeapon = new Sword(10,10,MyKnight)
    MyKnight.doAction(RandomWeapon,new equipWeapon())
    val atk = new attack()
    val exception = intercept[invalidInputException]{
      MyKnight.doAction(MyItem,atk)
    }
  }
}
