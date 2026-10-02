package unidades

class CaballeroTest extends munit.FunSuite:
  var caballero: Caballero = null

  override def beforeEach(context: BeforeEach): Unit =
    caballero = new Caballero("Arthur", 100, 15, 70)

  test("Un Caballero se crea con los valores correctos"):
    assertEquals(caballero.nombre, "Arthur")
    assertEquals(caballero.HpPoints, 100)
    assertEquals(caballero.DefensePoints, 15)
    assertEquals(caballero.weight, 70.0)

  test("Un Caballero nuevo no tiene arma equipada"):
    assertEquals(caballero.SlotArma, None)

  test("Un Caballero nuevo tiene el inventario vacío"):
    assert(caballero.inventarioUtilizables.isEmpty)
