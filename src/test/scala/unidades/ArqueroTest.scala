package unidades

class ArqueroTest extends munit.FunSuite:
  var arquero: Arquero = null

  override def beforeEach(context: BeforeEach): Unit =
    arquero = new Arquero("Legolas", 80, 8, 60)

  test("Un Arquero se crea con los valores correctos"):
    assertEquals(arquero.nombre, "Legolas")
    assertEquals(arquero.HpPoints, 80)
    assertEquals(arquero.DefensePoints, 8)
    assertEquals(arquero.weight, 60.0)

  test("Un Arquero nuevo no tiene arma equipada"):
    assertEquals(arquero.SlotArma, None)

  test("Un Arquero nuevo tiene el inventario vacío"):
    assert(arquero.inventarioUtilizables.isEmpty)
