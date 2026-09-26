package utilizables

class FuerzaMagicaTest extends munit.FunSuite:
  test("Una FuerzaMagica tiene el nombre correcto"):
    val pocion = new FuerzaMagica()
    assertEquals(pocion.nombre, "Pocion de fuerza magica")
