package utilizables

class ManaTest extends munit.FunSuite:
  test("Mana has given name"):
    val potion = new Mana("Test1")
    assertEquals(potion.nombre, "Test1")
    
  test("Two of them with distinct names"):
    val option1 = new Mana("Test1")
    val option2 = new Mana("Test2")
    assertNotEquals(option1.nombre, option2.nombre)
    
  test("of correct type, magic potion"):
    val potion = new Mana("A")
    assert(potion.isInstanceOf[PocionMagica])
