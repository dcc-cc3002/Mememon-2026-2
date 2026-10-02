package utilizables

import unidades.Arquero

class ArcoTest extends munit.FunSuite:
  var dueño: Arquero = null
  var arco: Arco = null

  override def beforeEach(context: BeforeEach): Unit =
    dueño = new Arquero("Legolas", 80, 8, 60)
    arco = new Arco("Arco Élfico", 18, 2, dueño)

  test("Un Arco se crea con los valores correctos"):
    assertEquals(arco.nombre, "Arco Élfico")
    assertEquals(arco.AttackPoints, 18)
    assertEquals(arco.weight, 2.0)
    assertEquals(arco.owner, dueño)
