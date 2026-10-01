package PocionesTest

import munit.FunSuite
import cl.uchile.dcc.Pociones.*

class PocionesTest extends FunSuite:

  test("Una poción de curación debe tener el nombre correcto") {
    val pocion = new PocionCuracion("Pocion de Curacion")

    assertEquals(pocion.nombre, "Pocion de Curacion")
  }

  test("Una poción de fortaleza debe tener el nombre correcto") {
    val pocion = new PocionFortaleza("Pocion de Fortaleza")

    assertEquals(pocion.nombre, "Pocion de Fortaleza")
  }

  test("Una poción de maná debe tener el nombre correcto") {
    val pocion = new PocionMana("Pocion de Mana")

    assertEquals(pocion.nombre, "Pocion de Mana")
  }

  test("Una poción de fuerza mágica debe tener el nombre correcto") {
    val pocion = new PocionFuerzaMagica("Pocion de Fuerza Magica")

    assertEquals(pocion.nombre, "Pocion de Fuerza Magica")
  }