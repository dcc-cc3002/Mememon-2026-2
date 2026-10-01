package ProgramadorTurnosTest

import munit.FunSuite
import cl.uchile.dcc.ProgramadorTurnos.*
import cl.uchile.dcc.Personajes.*
import cl.uchile.dcc.Armamento.*
import cl.uchile.dcc.Enemigo.*

class ProgramadorTurnosTest extends FunSuite:

  test("Se debe poder aumentar la barra de accion de una unidad") {
    val programador = new ProgramadorTurnos()
    val caballero = new Caballero("Alexis", 100, 20, 80)

    programador.agregarUnidad(caballero)
    programador.aumentarBarras(10)

    assertEquals(caballero.barraDeAccion, 10)
  }

  test("Se deben aumentar las barras de todas las unidades") {
    val programador = new ProgramadorTurnos()
    val caballero = new Caballero("Alexis", 100, 20, 80)
    val arquero = new Arquero("Link", 80, 15, 60)

    programador.agregarUnidad(caballero)
    programador.agregarUnidad(arquero)

    programador.aumentarBarras(20)

    assertEquals(caballero.barraDeAccion, 20)
    assertEquals(arquero.barraDeAccion, 20)
  }

  test("Se deben poder reiniciar las barras") {
    val programador = new ProgramadorTurnos()
    val caballero = new Caballero("Alexis", 100, 20, 80)
    val arquero = new Arquero("Link", 80, 15, 60)

    programador.agregarUnidad(caballero)
    programador.agregarUnidad(arquero)

    programador.aumentarBarras(20)
    programador.reiniciarBarra()

    assertEquals(caballero.barraDeAccion, 0)
    assertEquals(arquero.barraDeAccion, 0)
  }

  test("Una unidad eliminada no debe seguir aumentando su barra") {
    val programador = new ProgramadorTurnos()
    val caballero = new Caballero("Alexis", 100, 20, 80)

    programador.agregarUnidad(caballero)
    programador.aumentarBarras(10)

    programador.quitarUnidad(caballero)
    programador.aumentarBarras(10)

    assertEquals(caballero.barraDeAccion, 10)
  }

  test("Una unidad no completa la barra si no llega al maximo") {
    val programador = new ProgramadorTurnos()
    val caballero = new Caballero("Alexis", 100, 20, 80)

    programador.agregarUnidad(caballero)
    caballero.aumentarBarra(79)

    assertEquals(programador.barraCompleta(caballero), false)
  }

  test("Una unidad completa la barra si llega al maximo") {
    val programador = new ProgramadorTurnos()
    val caballero = new Caballero("Alexis", 100, 20, 80)

    programador.agregarUnidad(caballero)
    caballero.aumentarBarra(80)

    assertEquals(programador.barraCompleta(caballero), true)
  }

  test("Una unidad completa la barra si pasa el maximo") {
    val programador = new ProgramadorTurnos()
    val caballero = new Caballero("Alexis", 100, 20, 80)

    programador.agregarUnidad(caballero)
    caballero.aumentarBarra(100)

    assertEquals(programador.barraCompleta(caballero), true)
  }

  test("El exceso debe ser la diferencia entre la barra y el maximo") {
    val programador = new ProgramadorTurnos()
    val caballero = new Caballero("Alexis", 100, 20, 80)

    caballero.aumentarBarra(100)

    // Alexis tiene maximo 80, entonces se pasa por 20
    assertEquals(programador.excesoBarra(caballero), 20)
  }

  test("Debe devolver las unidades que completaron su barra") {
    val programador = new ProgramadorTurnos()
    val caballero = new Caballero("Alexis", 100, 20, 80)
    val arquero = new Arquero("Link", 80, 15, 60)

    programador.agregarUnidad(caballero)
    programador.agregarUnidad(arquero)

    caballero.aumentarBarra(90)
    arquero.aumentarBarra(50)

    val completas = programador.unidadesConBarraCompleta()

    assertEquals(completas.contains(caballero), true)
    assertEquals(completas.contains(arquero), false)
  }

  test("Las unidades deben ordenarse por cuanto se pasan de la barra") {
    val programador = new ProgramadorTurnos()
    val caballero = new Caballero("Alexis", 100, 20, 80)
    val arquero = new Arquero("Link", 80, 15, 60)

    caballero.aumentarBarra(85) // Alexis se pasa por 5
    arquero.aumentarBarra(80)   // Link se pasa por 20

    programador.agregarUnidad(caballero)
    programador.agregarUnidad(arquero)

    val completas = programador.unidadesConBarraCompleta()

    programador.ordenarPorExceso(completas)

    assertEquals(completas(0), arquero)
    assertEquals(completas(1), caballero)
  }

  test("Debe indicar que unidad tiene el turno") {
    val programador = new ProgramadorTurnos()
    val caballero = new Caballero("Alexis", 100, 20, 80)
    val arquero = new Arquero("Link", 80, 15, 60)

    caballero.aumentarBarra(85) // Alexis se pasa por 5
    arquero.aumentarBarra(80)   // Link se pasa por 20

    programador.agregarUnidad(caballero)
    programador.agregarUnidad(arquero)

    val turno = programador.unidadConTurno()

    assertEquals(turno, arquero)
  }

  test("La barra maxima de un personaje usa su peso y el del arma") {
    val caballero = new Caballero("Alexis", 100, 20, 80)
    val espada = new Espada("Espada", 20, 10, caballero, 0)

    caballero.arma += espada

    // 80 del personaje + 10 del arma
    assertEquals(caballero.barraMaxima, 90)
  }

  test("La barra maxima de un enemigo es su peso") {
    val enemigo = new Enemigo("Goblin", 100, 20, 10, 50)

    assertEquals(enemigo.barraMaxima, 50)
  }

  test("Se puede usar un ladron como unidad") {
    val programador = new ProgramadorTurnos()
    val ladron = new Ladron("Clyde", 70, 10, 50)

    programador.agregarUnidad(ladron)
    programador.aumentarBarras(10)

    assertEquals(ladron.barraDeAccion, 10)
  }