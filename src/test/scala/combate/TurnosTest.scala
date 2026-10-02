package combate

import unidades.{Enemigos, Caballero}

class TurnosTest extends munit.FunSuite:
  var ordena: Turnos = null
  var liviano: Enemigos = null
  var pesado: Enemigos = null

  override def beforeEach(context: BeforeEach): Unit =
    ordena = new Turnos()
    liviano = new Enemigos("A",20,2,10,5)
    pesado= new Enemigos("B",80,10,40,25)

  test("Nuevo no tiene unidades"):
    assert(ordena.unidadesEnBatalla.isEmpty)

  test("posible agregar unidad"):
    ordena.agregarUnidad(liviano)
    assert(ordena.unidadesEnBatalla.contains(liviano))