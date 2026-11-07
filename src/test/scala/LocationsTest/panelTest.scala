package cl.uchile.dcc
package LocationsTest

import Locations.panel

import munit.FunSuite

import scala.collection.mutable.ListBuffer

class panelTest extends FunSuite{
  test("Panel init works"){
    val PanelTest = new panel(2,2)
    assertEquals(PanelTest.Name,"Panel")
    assertEquals(PanelTest.North,None)
    assertEquals(PanelTest.South,None)
    assertEquals(PanelTest.East,None)
    assertEquals(PanelTest.West,None)
    
    
  }

}
