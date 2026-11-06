package utilizables

class CuracionTest extends munit.FunSuite:
  var pocion: Curacion = null

  override def beforeEach(context: BeforeEach): Unit =
    pocion = new Curacion("Elixir")

  test("Una poción de Curacion se crea con el nombre correcto"):
    assert(pocion.nombre == "Elixir")

  test("Dos pociones de Curacion con el mismo nombre son iguales"):
    val otra = new Curacion("Elixir")
    assertEquals(pocion, otra)
    assertEquals(otra, pocion)

  test("Dos pociones de Curacion con distinto nombre no son iguales"):
    assertNotEquals(pocion, new Curacion("Otra"))

  test("Una poción de Curacion y una de Fortaleza con el mismo nombre no son iguales"):
    val a: Pocion = pocion
    val b: Pocion = new Fortaleza("Elixir")
    assertNotEquals(a, b)
    assertNotEquals(b, a)