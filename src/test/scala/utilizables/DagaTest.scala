package utilizables

import unidades.{Caballero, Personajes}

class DagaTest extends munit.FunSuite:
  var arthur: Personajes = null
  var lancelot: Personajes = null
  var daga: Daga = null

  override def beforeEach(context: BeforeEach): Unit =
    arthur = new Caballero("Arthur", 100, 15, 70)
    lancelot = new Caballero("Lancelot", 90, 12, 65)
    daga = new Daga("Filo", 30, 2, arthur)

  test("Una Daga se crea con los valores correctos"):
    assert(daga.nombre == "Filo")
    assert(daga.AttackPoints == 30)
    assert(daga.weight == 2.0)
    assert(daga.owner == arthur)

  test("Dos Dagas con los mismos parámetros son iguales"):
    val otra = new Daga("Filo", 30, 2, arthur)
    assertEquals(daga, otra)
    assertEquals(otra, daga)

  test("Dos Dagas con distinto nombre no son iguales"):
    assertNotEquals(daga, new Daga("Otra", 30, 2, arthur))

  test("Dos Dagas con distintos puntos de ataque no son iguales"):
    assertNotEquals(daga, new Daga("Filo", 31, 2, arthur))

  test("Dos Dagas con distinto peso no son iguales"):
    assertNotEquals(daga, new Daga("Filo", 30, 3, arthur))

  test("Dos Dagas con distinto dueño no son iguales"):
    assertNotEquals(daga, new Daga("Filo", 30, 2, lancelot))

  test("Una Daga y un Arco con los mismos parámetros no son iguales"):
    val a: Arma = daga
    val b: Arma = new Arco("Filo", 30, 2, arthur)
    assertNotEquals(a, b)
    assertNotEquals(b, a)