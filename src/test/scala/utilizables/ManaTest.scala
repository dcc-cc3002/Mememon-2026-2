package utilizables

class ManaTest extends munit.FunSuite:
  test("Una Mana tiene el nombre correcto"):
    val pocion = new Mana()
    assertEquals(pocion.nombre, "Pocion de mana")
