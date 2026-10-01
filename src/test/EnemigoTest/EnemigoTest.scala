package EnemigoTest

import munit.FunSuite
import cl.uchile.dcc.Enemigo.*

class EnemigoTest extends FunSuite:

  test("Un enemigo debe tener los atributos correctos") {
    val enemigo = new Enemigo("Goblin", 100, 20, 10, 50)

    assertEquals(enemigo.nombre, "Goblin")
    assertEquals(enemigo.PuntosDeVida, 100)
    assertEquals(enemigo.ataque, 20)
    assertEquals(enemigo.defensa, 10)
    assertEquals(enemigo.peso, 50)
  }