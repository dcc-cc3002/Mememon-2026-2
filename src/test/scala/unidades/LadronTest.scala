package unidades

class LadronTest extends munit.FunSuite:
  var ladron: Ladron = null

  override def beforeEach(context: BeforeEach): Unit =
    ladron = new Ladron("Locke", 70, 6, 55)

  test("Un Ladron se crea con los valores correctos"):
    assertEquals(ladron.nombre, "Locke")
    assertEquals(ladron.HpPoints, 70)
    assertEquals(ladron.DefensePoints, 6)
    assertEquals(ladron.weight, 55.0)

  test("Un Ladron nuevo no tiene arma equipada"):
    assertEquals(ladron.SlotArma, None)

  test("Un Ladron nuevo tiene el inventario vacío"):
    assert(ladron.inventarioUtilizables.isEmpty)
