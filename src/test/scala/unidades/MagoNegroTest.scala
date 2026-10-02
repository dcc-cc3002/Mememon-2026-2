package unidades

class MagoNegroTest extends munit.FunSuite:
  var mago: MagoNegro = null

  override def beforeEach(context: BeforeEach): Unit =
    mago = new MagoNegro("Merlin", 60, 5, 50, 40)

  test("Un MagoNegro se crea con los valores correctos"):
    assertEquals(mago.nombre, "Merlin")
    assertEquals(mago.HpPoints, 60)
    assertEquals(mago.DefensePoints, 5)
    assertEquals(mago.weight, 50.0)
    assertEquals(mago.ManaPoints, 40.0)

  test("Un MagoNegro nuevo no tiene arma equipada"):
    assertEquals(mago.SlotArma, None)

  test("Un MagoNegro nuevo tiene el inventario vacío"):
    assert(mago.inventarioUtilizables.isEmpty)
