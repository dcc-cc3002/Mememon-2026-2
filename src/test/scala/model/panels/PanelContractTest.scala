package cl.uchile.dcc
package model.panels

import model.units.{Character, Knight, Enemy}

class PanelContractTest extends munit.FunSuite:
  var panel: Option[PanelContract] = None
  var knight: Option[Character] = None

  override def beforeEach(context: BeforeEach): Unit = {
    knight = Some(new Knight("Juan", 90, 10, 55, None, Nil))
    panel = Some(new Panel(1, 2 , List(knight.get)))
  }

  test("Panel fulfills the PanelContract"):
    val p = panel.get
    assertEquals(p.x, 1)
    assertEquals(p.y, 2)
    assertEquals(p.units, List(knight.get))


  test("addUnit places a new unit at the end of the panel"):
    val enemy = new Enemy("Goblin", 100, 25, 10, 40)
    panel.get.addUnit(enemy)
    assertEquals(panel.get.units, List(knight.get, enemy))

  test("removeUnit takes a unit out of the panel"):
    panel.get.removeUnit(knight.get)
    assertEquals(panel.get.units, Nil)

  test("addUnit does not repeat a unit that is already in the panel"):
    panel.get.addUnit(knight.get)
    assertEquals(panel.get.units, List(knight.get))

  test("removeUnit does nothing if the unit is not in the panel"):
    val enemy = new Enemy("Goblin", 100, 25, 10, 40)
    panel.get.removeUnit(enemy)
    assertEquals(panel.get.units, List(knight.get))