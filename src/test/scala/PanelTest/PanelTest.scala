package cl.uchile.dcc
package PanelTest

import Mapa.Panel

import munit.FunSuite

import scala.collection.mutable.ListBuffer

class PanelTest extends FunSuite{
  test("Panel init works"){
    val PanelTest = new Panel(2,2,3,3)
    val expected  = ListBuffer((1,2),(3,2),(2,1),(2,3))
    assertEquals(PanelTest.Neighbourhood,expected)
    assertEquals(ListBuffer[Character](),PanelTest.UnitsList)
  }

}
