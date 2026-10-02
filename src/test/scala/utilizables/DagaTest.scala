package utilizables

import unidades.Ladron

class DagaTest extends munit.FunSuite:
  var dueño: Ladron = null
  var daga: Daga = null

  override def beforeEach(context: BeforeEach): Unit =
    dueño = new Ladron("Locke", 70, 6, 55)
    daga = new Daga("Filo Sombrío", 15, 1, dueño)

  test("Una Daga se crea con los valores correctos"):
    assertEquals(daga.nombre, "Filo Sombrío")
    assertEquals(daga.AttackPoints, 15)
    assertEquals(daga.weight, 1.0)
    assertEquals(daga.owner, dueño)
