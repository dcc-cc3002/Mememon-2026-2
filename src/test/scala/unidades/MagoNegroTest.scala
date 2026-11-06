package unidades

class MagoNegroTest extends munit.FunSuite:
  var mago: MagoNegro = null

  override def beforeEach(context: BeforeEach): Unit =
    mago = new MagoNegro("Vivi", 55, 3, 40, 60)

  test("Un Mago Negro se crea con los valores correctos"):
    assert(mago.nombre == "Vivi")
    assert(mago.HpPoints == 55)
    assert(mago.DefensePoints == 3)
    assert(mago.weight == 40.0)
    assert(mago.ManaPoints == 60)

  test("Un Mago Negro nuevo no tiene arma equipada"):
    assert(mago.SlotArma == None)

  test("Un Mago Negro nuevo tiene el inventario vacío"):
    assert(mago.inventarioUtilizables.isEmpty)

  test("Dos Magos Negros con los mismos parámetros son iguales"):
    val otro = new MagoNegro("Vivi", 55, 3, 40, 60)
    assertEquals(mago, otro)
    assertEquals(otro, mago)

  test("Dos Magos Negros con distinto nombre no son iguales"):
    assertNotEquals(mago, new MagoNegro("Otro", 55, 3, 40, 60))

  test("Dos Magos Negros con distinta vida no son iguales"):
    assertNotEquals(mago, new MagoNegro("Vivi", 54, 3, 40, 60))

  test("Dos Magos Negros con distinta defensa no son iguales"):
    assertNotEquals(mago, new MagoNegro("Vivi", 55, 4, 40, 60))

  test("Dos Magos Negros con distinto peso no son iguales"):
    assertNotEquals(mago, new MagoNegro("Vivi", 55, 3, 41, 60))

  test("Dos Magos Negros con distinto maná no son iguales"):
    assertNotEquals(mago, new MagoNegro("Vivi", 55, 3, 40, 99))

  test("Un Mago Negro y un Mago Blanco con los mismos parámetros no son iguales"):
    val a: Personajes = mago
    val b: Personajes = new MagoBlanco("Vivi", 55, 3, 40, 60)
    assertNotEquals(a, b)
    assertNotEquals(b, a)