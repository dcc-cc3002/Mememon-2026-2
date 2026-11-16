package cl.uchile.dcc
package ControllerTest

import cl.uchile.dcc.Units.Knight
import cl.uchile.dcc.controller.GameController
import munit.FunSuite

class ControllerTest extends FunSuite{

  test("GameController works") {
    val MyNewController = new GameController()
    val MyKnight = new Knight(10, 10, 10)
    assertEquals(MyNewController.getCurrentUnit, None)
    MyNewController.putUnit(MyKnight)
    MyNewController.NextTurn()
    assertEquals(MyNewController.getCurrentUnit,Some(MyKnight))
  }
}
