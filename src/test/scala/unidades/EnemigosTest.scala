package unidades

class EnemigosTest extends munit.FunSuite:
  var enemigo: Enemigos = null

  override def beforeEach(context: BeforeEach): Unit =
    enemigo = new Enemigos("Globin",40,10,5,20)

  test("Un enemigo se crea con los valores indicados y correctos"):
    assertEquals(enemigo.nombre, "Globin")
    assertEquals(enemigo.HpPoints, 40)
    assertEquals(enemigo.DefensePoints, 10)
    assertEquals(enemigo.weight, 5.0)
    assertEquals(enemigo.AttackPoints, 20)