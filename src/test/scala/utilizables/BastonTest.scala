package utilizables

import unidades.MagoBlanco

class BastonTest extends munit.FunSuite:
  var dueño: MagoBlanco = null
  var baston: Baston = null

  override def beforeEach(context: BeforeEach): Unit =
    dueño = new MagoBlanco("Gandalf", 65, 7, 52, 45)
    baston = new Baston("Bastón Blanco", 8, 2, dueño,12)

  test("Un Baston se crea con los valores correctos"):
    assertEquals(baston.nombre, "Bastón Blanco")
    assertEquals(baston.AttackPoints, 8)
    assertEquals(baston.weight, 2.0)
    assertEquals(baston.owner, dueño)
    assertEquals(baston.AttackPointsM, 12)
  test("Un Baston es un ArmaMagic"):
    assert(baston.isInstanceOf[ArmaMagic])
