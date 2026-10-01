package AccionTest
import munit.FunSuite
import cl.uchile.dcc.Accion.*

class AccionTest extends FunSuite:

  test("Atacar debe tener el nombre correcto") {
    val atacar = new Atacar()
    assertEquals(atacar.nombre, "Atacar")
  }

  test("Moverse debe tener el nombre correcto") {
    val moverse = new Moverse()
    assertEquals(moverse.nombre, "Moverse")
  }

  test("EquiparArma debe tener el nombre correcto y una lista de armas vacía") {
    val equiparArma = new EquiparArma()

    assertEquals(equiparArma.nombre, "Equipar Arma")
    assertEquals(equiparArma.armas.isEmpty, true)
  }

  test("ConsumirPocion debe tener el nombre correcto y una lista de pociones vacía") {
    val consumirPocion = new ConsumirPocion()

    assertEquals(consumirPocion.nombre, "Consumir pocion")
    assertEquals(consumirPocion.pociones.isEmpty, true)
  }

  test("Trueno debe tener el nombre correcto") {
    val trueno = new Trueno()
    assertEquals(trueno.nombre, "Trueno")
  }

  test("Meteorito debe tener el nombre correcto") {
    val meteorito = new Meteorito()
    assertEquals(meteorito.nombre, "Meteorito")
  }

  test("Curacion debe tener el nombre correcto") {
    val curacion = new Curacion()
    assertEquals(curacion.nombre, "Curacion")
  }

  test("Purificacion debe tener el nombre correcto") {
    val purificacion = new Purificacion()
    assertEquals(purificacion.nombre, "Purificacion")
  }


