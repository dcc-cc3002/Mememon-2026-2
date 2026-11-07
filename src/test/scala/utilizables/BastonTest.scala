package utilizables

import unidades.{Caballero, Personajes}

class BastonTest extends munit.FunSuite:
  var arthur: Personajes = null
  var artur2: Personajes = null
  var baston: Baston = null

  override def beforeEach(context: BeforeEach): Unit =
    arthur = new Caballero("Arthur", 100, 15, 70)
    artur2 = new Caballero("Lancelot", 90, 12, 65)
    baston = new Baston("Trueno", 15, 4, arthur, 45)

  test("Un Bastón se crea con los valores correctos"):
    assert(baston.nombre == "Trueno")
    assert(baston.AttackPoints == 15)
    assert(baston.weight == 4.0)
    assert(baston.owner == arthur)
    assert(baston.AttackPointsM == 45)

  test("Dos Bastones con los mismos parámetros son iguales"):
    val otro = new Baston("Trueno", 15, 4, arthur, 45)
    assertEquals(baston, otro)
    assertEquals(otro, baston)

  test("Dos Bastones con distinto nombre no son iguales"):
    assertNotEquals(baston, new Baston("Otro", 15, 4, arthur, 45))

  test("Dos Bastones con distintos puntos de ataque no son iguales"):
    assertNotEquals(baston, new Baston("Trueno", 16, 4, arthur, 45))

  test("Dos Bastones con distinto peso no son iguales"):
    assertNotEquals(baston, new Baston("Trueno", 15, 5, arthur, 45))

  test("Dos Bastones con distinto dueño no son iguales"):
    assertNotEquals(baston, new Baston("Trueno", 15, 4, artur2, 45))

  test("Dos Bastones con distinto ataque mágico no son iguales"):
    assertNotEquals(baston, new Baston("Trueno", 15, 4, arthur, 46))

  test("Un Bastón y una Varita con los mismos parámetros no son iguales"):
    val a: Arma = baston
    val b: Arma = new Varita("Trueno", 15, 4, arthur, 45)
    assertNotEquals(a, b)
    assertNotEquals(b, a)