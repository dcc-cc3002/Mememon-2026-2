package PersonajesTest

import munit.FunSuite
import cl.uchile.dcc.Personajes.*

class PersonajesTest extends FunSuite:

  test("Un caballero debe tener los atributos correctos") {
    val caballero = new Caballero("Alexis", 100, 50, 70)

    assertEquals(caballero.nombre, "Alexis")
    assertEquals(caballero.puntosDeVida, 100)
    assertEquals(caballero.defensa, 50)
    assertEquals(caballero.peso, 70)
    assertEquals(caballero.arma.isEmpty, true)
    assertEquals(caballero.inventario.isEmpty, true)
  }

  test("Un arquero debe tener los atributos correctos") {
    val arquero = new Arquero("Link", 80, 10, 40)

    assertEquals(arquero.nombre, "Link")
    assertEquals(arquero.puntosDeVida, 80)
    assertEquals(arquero.defensa, 10)
    assertEquals(arquero.peso, 40)
    assertEquals(arquero.arma.isEmpty, true)
    assertEquals(arquero.inventario.isEmpty, true)
  }

  test("Un ladrón debe tener los atributos correctos") {
    val ladron = new Ladron("Clyde", 70, 20, 40)

    assertEquals(ladron.nombre, "Clyde")
    assertEquals(ladron.puntosDeVida, 70)
    assertEquals(ladron.defensa, 20)
    assertEquals(ladron.peso, 40)
    assertEquals(ladron.arma.isEmpty, true)
    assertEquals(ladron.inventario.isEmpty, true)
  }

  test("Un mago negro debe tener los atributos correctos") {
    val magoNegro = new MagoNegro("Voldemort", 100, 30, 40, 100)

    assertEquals(magoNegro.nombre, "Voldemort")
    assertEquals(magoNegro.puntosDeVida, 100)
    assertEquals(magoNegro.defensa, 30)
    assertEquals(magoNegro.peso, 40)
    assertEquals(magoNegro.puntosMana, 100)
    assertEquals(magoNegro.arma.isEmpty, true)
    assertEquals(magoNegro.inventario.isEmpty, true)
  }

  test("Un mago blanco debe tener los atributos correctos") {
    val magoBlanco = new MagoBlanco("Dumbledore", 100, 20, 45, 120)

    assertEquals(magoBlanco.nombre, "Dumbledore")
    assertEquals(magoBlanco.puntosDeVida, 100)
    assertEquals(magoBlanco.defensa, 20)
    assertEquals(magoBlanco.peso, 45)
    assertEquals(magoBlanco.puntosMana, 120)
    assertEquals(magoBlanco.arma.isEmpty, true)
    assertEquals(magoBlanco.inventario.isEmpty, true)
  }