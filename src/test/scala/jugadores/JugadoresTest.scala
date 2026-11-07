package jugadores

class JugadorTest extends munit.FunSuite:
  test("Un jugador nuevo tiene la lista de unidades vacias: "):
    val jugador = new Jugadores()
    assert(jugador.ListaUnidades.isEmpty)
  test("Un Jugador nuevo no esta derrotado "):
    val jugador = new Jugadores()
    //notar que assert equals, revisa si ambos son iguales, los dos argumentos dados
    assertEquals(jugador.VictoriaOrDefeat, false)