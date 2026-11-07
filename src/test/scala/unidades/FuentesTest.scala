package unidades

class FuentesTest extends munit.FunSuite:
  var caballero: Caballero = null
  var negro: MagoNegro = null
  var blanco: MagoBlanco = null
  var enemigo: Enemigos = null

  override def beforeEach(context: BeforeEach): Unit =
    caballero = new Caballero("Arthur", 100, 15, 70)
    negro = new MagoNegro("Vivi", 60, 4, 40, 50)
    blanco = new MagoBlanco("Rosa", 60, 4, 45, 50)
    enemigo = new Enemigos("Goblin", 100, 10, 30, 20)

  test("capaz de hacer acciones"):
    assert(caballero.acciones.length == 4)
    assert(caballero.buscarAccion("Atacar").isDefined)
    assert(caballero.buscarAccion("Moverse").isDefined)
    assert(caballero.buscarAccion("Equipar arma").isDefined)
    assert(caballero.buscarAccion("Consumir pocion").isDefined)

  test("lanzar hechizos caracteristicos"):
    assert(negro.acciones.length == 6)
    assert(negro.buscarAccion("Trueno").isDefined)
    assert(negro.buscarAccion("Meteorito").isDefined)
    assert(negro.buscarAccion("Curacion").isEmpty)

  test("curacion y purificacion"):
    assert(blanco.acciones.length == 6)
    assert(blanco.buscarAccion("Curacion").isDefined)
    assert(blanco.buscarAccion("Purificacion").isDefined)
    assert(blanco.buscarAccion("Trueno").isEmpty)

  test("atacar y moverse"):
    assert(enemigo.acciones.length == 2)
    assert(enemigo.buscarAccion("Atacar").isDefined)
    assert(enemigo.buscarAccion("Moverse").isDefined)
    assert(enemigo.buscarAccion("Equipar arma").isEmpty)

  test("accion encontrada tiene nombre buscado"):
    assert(caballero.buscarAccion("Moverse").get.nombre == "Moverse")

  test("si accion no existe solo es none"):
    assert(caballero.buscarAccion("Volar") == None)
