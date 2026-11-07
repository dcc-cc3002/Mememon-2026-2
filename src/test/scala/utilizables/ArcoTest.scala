package utilizables

import unidades.{Caballero, Personajes}

class ArcoTest extends munit.FunSuite:
  var arthur: Personajes = null
  var lancelot: Personajes = null
  var arco: Arco = null

  override def beforeEach(context: BeforeEach): Unit =
    arthur = new Caballero("Arthur", 100, 15, 70)
    lancelot = new Caballero("Lancelot", 90, 12, 65)
    arco = new Arco("Halcón", 40, 3, arthur)

  test("Un Arco se crea con los valores correctos"):
    assert(arco.nombre == "Halcón")
    assert(arco.AttackPoints == 40)
    assert(arco.weight == 3.0)
    assert(arco.owner == arthur)

  test("Dos Arcos con los mismos parámetros son iguales"):
    val otro = new Arco("Halcón", 40, 3, arthur)
    assertEquals(arco, otro)
    assertEquals(otro, arco)

  test("Dos Arcos con distinto nombre no son iguales"):
    assertNotEquals(arco, new Arco("Otro", 40, 3, arthur))

  test("Dos Arcos con distintos puntos de ataque no son iguales"):
    assertNotEquals(arco, new Arco("Halcón", 41, 3, arthur))

  test("Dos Arcos con distinto peso no son iguales"):
    assertNotEquals(arco, new Arco("Halcón", 40, 4, arthur))

  test("Dos Arcos con distinto dueño no son iguales"):
    assertNotEquals(arco, new Arco("Halcón", 40, 3, lancelot))

  test("Un Arco y una Espada con los mismos parámetros no son iguales"):
    val a: Arma = arco
    val b: Arma = new Espada("Halcón", 40, 3, arthur)
    assertNotEquals(a, b)
    assertNotEquals(b, a)