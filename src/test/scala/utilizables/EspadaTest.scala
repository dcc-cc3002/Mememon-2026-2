package utilizables

import unidades.Caballero

class EspadaTest extends munit.FunSuite:
  var dueño: Caballero = null
  var espada: Espada = null

  override def beforeEach(context: BeforeEach): Unit =
    dueño = new Caballero("Arthur", 100, 15, 70)
    espada = new Espada("Excalibur", 25, 3, dueño)

  test("Una Espada se crea con los valores correctos"):
    assertEquals(espada.nombre, "Excalibur")
    assertEquals(espada.AttackPoints, 25)
    assertEquals(espada.weight, 3.0)
    assertEquals(espada.owner, dueño)
