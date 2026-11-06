package utilizables

class ManaTest extends munit.FunSuite:
  var pocion: Mana = null

  override def beforeEach(context: BeforeEach): Unit =
    pocion = new Mana("A")

  test(" poción de mana creada con nombre dado"):
    assert(pocion.nombre == "A")

  test("pociones mana mismo nombre son iguales"):
    val otra = new Mana("A")
    assertEquals(pocion, otra)
    assertEquals(otra, pocion)

  test("pociones de mana con distinto nombre no iguales"):
    assertNotEquals(pocion, new Mana("Otra"))

  test("poción Mana y de fuerza magica con mismo nombre no iguales"):
    val a: Pocion = pocion
    val b: Pocion = new FuerzaMagica("A")
    assertNotEquals(a, b)
    assertNotEquals(b, a)