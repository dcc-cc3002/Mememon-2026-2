package utilizables

import unidades.{Caballero, Personajes}

class VaritaTest extends munit.FunSuite:
  var arthur: Personajes = null
  var artur2: Personajes = null
  var varita: Varita = null

  override def beforeEach(context: BeforeEach): Unit =
    arthur = new Caballero("Arthur", 100, 15, 70)
    artur2 = new Caballero("Lancelot", 90, 12, 65)
    varita = new Varita("Rayo", 10, 1, arthur, 30)

  test("Una Varita se crea con los valores correctos"):
    assert(varita.nombre == "Rayo")
    assert(varita.AttackPoints == 10)
    assert(varita.weight == 1.0)
    assert(varita.owner == arthur)
    assert(varita.AttackPointsM == 30)

  test("Dos Varitas con los mismos parámetros son iguales"):
    val otra = new Varita("Rayo", 10, 1, arthur, 30)
    assertEquals(varita, otra)
    assertEquals(otra, varita)

  test("Dos Varitas con distinto nombre no son iguales"):
    assertNotEquals(varita, new Varita("Otra", 10, 1, arthur, 30))

  test("Dos Varitas con distintos puntos de ataque no son iguales"):
    assertNotEquals(varita, new Varita("Rayo", 11, 1, arthur, 30))

  test("Dos Varitas con distinto peso no son iguales"):
    assertNotEquals(varita, new Varita("Rayo", 10, 2, arthur, 30))

  test("Dos Varitas con distinto dueño no son iguales"):
    assertNotEquals(varita, new Varita("Rayo", 10, 1, artur2, 30))

  test("Dos Varitas con distinto ataque mágico no son iguales"):
    assertNotEquals(varita, new Varita("Rayo", 10, 1, arthur, 31))

  test("Una Varita y un Bastón con los mismos parámetros no son iguales"):
    val a: Arma = varita
    val b: Arma = new Baston("Rayo", 10, 1, arthur, 30)
    assertNotEquals(a, b)
    assertNotEquals(b, a)