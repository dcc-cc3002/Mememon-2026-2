package utilizables

class FortalezaTest extends munit.FunSuite:
  test("Una Fortaleza tiene el nombre correcto, que se le dio"):
    val pocion = new Fortaleza("Pocion de fortaleza A")
    assertEquals(pocion.nombre,"Pocion de fortaleza A")
    
    test("Two of them with different names"):
      val option1 = new Fortaleza("Pocion de fortaleza A")
      val option2 = new Fortaleza("Pocion de fortaleza B")
      assertNotEquals(option1.nombre, option2.nombre)
