package unidades

class LadronTest extends munit.FunSuite:
  var ladron: Ladron = null

  override def beforeEach(context: BeforeEach): Unit =
    ladron = new Ladron("Zidane", 70, 6, 55)

  test("Un Ladrón se crea con los valores correctos"):
    assert(ladron.nombre == "Zidane")
    assert(ladron.HpPoints == 70)
    assert(ladron.DefensePoints == 6)
    assert(ladron.weight == 55.0)

  test("Un Ladrón nuevo no tiene arma equipada"):
    assert(ladron.SlotArma == None)

  test("Un Ladrón nuevo tiene el inventario vacío"):
    assert(ladron.inventarioUtilizables.isEmpty)

  test("Dos Ladrones con los mismos parámetros son iguales"):
    val otro = new Ladron("Zidane", 70, 6, 55)
    assertEquals(ladron, otro)
    assertEquals(otro, ladron)

  test("Dos Ladrones con distinto nombre no son iguales"):
    assertNotEquals(ladron, new Ladron("Otro", 70, 6, 55))

  test("Dos Ladrones con distinta vida no son iguales"):
    assertNotEquals(ladron, new Ladron("Zidane", 69, 6, 55))

  test("Dos Ladrones con distinta defensa no son iguales"):
    assertNotEquals(ladron, new Ladron("Zidane", 70, 7, 55))

  test("Dos Ladrones con distinto peso no son iguales"):
    assertNotEquals(ladron, new Ladron("Zidane", 70, 6, 56))

  test("Un Ladrón y un Caballero con los mismos parámetros no son iguales"):
    val a: Personajes = ladron
    val b: Personajes = new Caballero("Zidane", 70, 6, 55)
    assertNotEquals(a, b)
    assertNotEquals(b, a)