package utilizables

class FuerzaMagicaTest extends munit.FunSuite:
  test("Una FuerzaMagica creada con nombre que se da"):
    val potion = new FuerzaMagica("Potion test A")
    assertEquals(potion.nombre, "Potion test A")

  test("Two potions with different names"):
    val option1 = new FuerzaMagica("Test1")
    val option2 = new FuerzaMagica("Test2")
    assertNotEquals(option1.nombre,option2.nombre)

  test("Potion is of  magic type"):
    val option3 = new FuerzaMagica("Test3")
    assert(option3.isInstanceOf[PocionMagica])