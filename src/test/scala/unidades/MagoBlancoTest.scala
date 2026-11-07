package unidades

class MagoBlancoTest extends munit.FunSuite:
  var mago: MagoBlanco = null

  override def beforeEach(context: BeforeEach): Unit =
    mago = new MagoBlanco("Rosa", 60, 4, 45, 50)

  test("Un Mago Blanco se crea con los valores correctos"):
    assert(mago.nombre == "Rosa")
    assert(mago.HpPoints == 60)
    assert(mago.DefensePoints == 4)
    assert(mago.weight == 45.0)
    assert(mago.ManaPoints == 50)

  test("Un Mago Blanco nuevo no tiene arma equipada"):
    assert(mago.SlotArma == None)

  test("Un Mago Blanco nuevo tiene el inventario vacío"):
    assert(mago.inventarioUtilizables.isEmpty)

  test("Dos Magos Blancos con los mismos parámetros son iguales"):
    val otro = new MagoBlanco("Rosa", 60, 4, 45, 50)
    assertEquals(mago, otro)
    assertEquals(otro, mago)

  test("Dos Magos Blancos con distinto nombre no son iguales"):
    assertNotEquals(mago, new MagoBlanco("Otro", 60, 4, 45, 50))

  test("Dos Magos Blancos con distinta vida no son iguales"):
    assertNotEquals(mago, new MagoBlanco("Rosa", 59, 4, 45, 50))

  test("Dos Magos Blancos con distinta defensa no son iguales"):
    assertNotEquals(mago, new MagoBlanco("Rosa", 60, 5, 45, 50))

  test("Dos Magos Blancos con distinto peso no son iguales"):
    assertNotEquals(mago, new MagoBlanco("Rosa", 60, 4, 46, 50))

  test("Dos Magos Blancos con distinto maná no son iguales"):
    assertNotEquals(mago, new MagoBlanco("Rosa", 60, 4, 45, 99))

  test("Un Mago Blanco y un Mago Negro con los mismos parámetros no son iguales"):
    val a: Personajes = mago
    val b: Personajes = new MagoNegro("Rosa", 60, 4, 45, 50)
    assertNotEquals(a, b)
    assertNotEquals(b, a)