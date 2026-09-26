package utilizables

import unidades.MagoNegro

class VaritaTest extends munit.FunSuite:
  var dueño: MagoNegro = null
  var varita: Varita = null

  override def beforeEach(context: BeforeEach): Unit =
    dueño = new MagoNegro("Merlin", 60, 5, 50, 40)
    varita = new Varita("Vara de Saúco", 10, 1, dueño, 35)

  test("Una Varita se crea con los valores correctos"):
    assertEquals(varita.nombre, "Vara de Saúco")
    assertEquals(varita.AttackPoints, 10)
    assertEquals(varita.weight, 1.0)
    assertEquals(varita.owner, dueño)
    assertEquals(varita.AttackPointsM, 35)

//recordar que weight, no es int, es double