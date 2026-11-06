package utilizables

class FuerzaMagicaTest extends munit.FunSuite:
  var pocion: FuerzaMagica = null

  override def beforeEach(context: BeforeEach): Unit =
    pocion = new FuerzaMagica("A")

  test("poción fuerza magica crea con nombre dado"):
    assert(pocion.nombre == "A")

  test("Dos pociones de FuerzaMagica con el mismo nombre son iguales"):
    val otra = new FuerzaMagica("A")
    assertEquals(pocion, otra)
    assertEquals(otra, pocion)

  test("Dos pociones de FuerzaMagica con distinto nombre no son iguales"):
    assertNotEquals(pocion, new FuerzaMagica("m"))

  test("Una poción de FuerzaMagica y una de Mana con el mismo nombre no son iguales"):
    val a: Pocion = pocion
    val b: Pocion = new Mana("A")
    assertNotEquals(a, b)
    assertNotEquals(b, a)