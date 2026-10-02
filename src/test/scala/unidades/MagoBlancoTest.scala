package unidades

class MagoBlancoTest extends munit.FunSuite:
  var mago: MagoBlanco = null

  override def beforeEach(context: BeforeEach): Unit =
    mago = new MagoBlanco("Gandalf", 65, 7, 52, 45)

  test("Un MagoBlanco se crea con los valores correctos"):
    assertEquals(mago.nombre, "Gandalf")
    assertEquals(mago.HpPoints, 65)
    assertEquals(mago.DefensePoints, 7)
    assertEquals(mago.weight, 52.0)
    assertEquals(mago.ManaPoints, 45.0)

  test("Un MagoBlanco nuevo no tiene arma equipada"):
    assertEquals(mago.SlotArma, None)

  test("Un MagoBlanco nuevo tiene el inventario vacío"):
    assert(mago.inventarioUtilizables.isEmpty)



