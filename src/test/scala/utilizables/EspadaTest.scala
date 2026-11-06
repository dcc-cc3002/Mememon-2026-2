package utilizables

import unidades.{Caballero, Personajes}

class EspadaTest extends munit.FunSuite:
  var arthur: Personajes = null
  var lancelot: Personajes = null
  var espada: Espada = null

  override def beforeEach(context: BeforeEach): Unit =
    arthur = new Caballero("Arthur", 100, 15, 70)
    lancelot = new Caballero("Lancelot", 90, 12, 65)
    espada = new Espada("Excalibur", 50, 5, arthur)

  test("Una Espada se crea con los valores correctos"):
    assert(espada.nombre == "Excalibur")
    assert(espada.AttackPoints == 50)
    assert(espada.weight == 5.0)
    assert(espada.owner == arthur)

  test("Dos Espadas con los mismos parámetros son iguales"):
    val otra = new Espada("Excalibur", 50, 5, arthur)
    assertEquals(espada, otra)
    assertEquals(otra, espada)

  test("Dos Espadas con distinto nombre no son iguales"):
    assertNotEquals(espada, new Espada("Otra", 50, 5, arthur))

  test("Dos Espadas con distintos puntos de ataque no son iguales"):
    assertNotEquals(espada, new Espada("Excalibur", 51, 5, arthur))

  test("Dos Espadas con distinto peso no son iguales"):
    assertNotEquals(espada, new Espada("Excalibur", 50, 6, arthur))

  test("Dos Espadas con distinto dueño no son iguales"):
    assertNotEquals(espada, new Espada("Excalibur", 50, 5, lancelot))

  test("Una Espada y una Daga con los mismos parámetros no son iguales"):
    val a: Arma = espada
    val b: Arma = new Daga("Excalibur", 50, 5, arthur)
    assertNotEquals(a, b)
    assertNotEquals(b, a)