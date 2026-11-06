package unidades

class EnemigosTest extends munit.FunSuite:
  var enemigo: Enemigos= null

  override def beforeEach(context: BeforeEach): Unit =
    enemigo = new Enemigos("Goblin", 50, 12, 30, 5)

  test("Un Enemigo se crea con los valores correctos"):
    assert(enemigo.nombre == "Goblin")
    assert(enemigo.HpPoints == 50)
    assert(enemigo.DefensePoints == 12)
    assert(enemigo.weight == 30.0)
    assert(enemigo.AttackPoints == 5)

  test("Dos Enemigos con los mismos parámetros son iguales"):
    val otro = new Enemigos("Goblin", 50, 12, 30, 5)
    assertEquals(enemigo, otro)
    assertEquals(otro, enemigo)

  test("Dos Enemigos con distinto nombre no son iguales"):
    assertNotEquals(enemigo, new Enemigos("Orco", 50, 12, 30, 5))

  test("Dos Enemigos con distinta vida no son iguales"):
    assertNotEquals(enemigo, new Enemigos("Goblin", 49, 12, 30, 5))

  test("Dos Enemigos con distinta defensa no son iguales"):
    assertNotEquals(enemigo, new Enemigos("Goblin", 50, 13, 30, 5))

  test("Dos Enemigos con distinto peso no son iguales"):
    assertNotEquals(enemigo, new Enemigos("Goblin", 50, 12, 31, 5))

  test("Dos Enemigos con distinto ataque no son iguales"):
    assertNotEquals(enemigo, new Enemigos("Goblin", 50, 12, 30, 6))