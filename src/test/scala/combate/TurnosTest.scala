package combate

import unidades.{Caballero, Enemigos}
import utilizables.Espada

class TurnosTest extends munit.FunSuite:
  var turnos: Turnos = null
  var liviano: Enemigos = null
  var pesado: Enemigos = null
  var caballero: Caballero = null

  override def beforeEach(context: BeforeEach): Unit =
    turnos = new Turnos()
    liviano = new Enemigos("A", 20, 2, 10, 5)     // barra máxima 10
    pesado = new Enemigos("B", 80, 10, 40, 25)    // barra máxima 40
    caballero = new Caballero("C", 100, 15, 70)   // barra máxima 70 sin arma

  test("programadornuevo no unidades"):
    assert(turnos.unidadesEnBatalla.isEmpty)

  test("posible agregar unidad"):
    turnos.agregarUnidad(liviano)
    assert(turnos.unidadesEnBatalla.contains(liviano))

  test("agregar dos veces la misma cosa no duplica"):
    turnos.agregarUnidad(liviano)
    turnos.agregarUnidad(liviano)
    assert(turnos.unidadesEnBatalla == List(liviano))

  test("acepta personajes, enemigos a la vez"):
    turnos.agregarUnidad(caballero)
    turnos.agregarUnidad(pesado)
    assert(turnos.unidadesEnBatalla.contains(caballero))
    assert(turnos.unidadesEnBatalla.contains(pesado))

  test("posible quitar unidad sin afectar al resto"):
    turnos.agregarUnidad(liviano)
    turnos.agregarUnidad(pesado)
    turnos.quitarUnidad(liviano)
    assert(!turnos.unidadesEnBatalla.contains(liviano))
    assert(turnos.unidadesEnBatalla.contains(pesado))

  test("quitar unidad que no está no hace que cambie nada"):
    turnos.agregarUnidad(pesado)
    turnos.quitarUnidad(liviano)
    assert(turnos.unidadesEnBatalla == List(pesado))

  test("barra máxima de enemigo es su peso"):
    assert(turnos.maxbarraDe(pesado) == 40.0)

  test("barra máxima de personaje sin arma espeso"):
    assert(turnos.maxbarraDe(caballero) == 70.0)

  test("barra máxima de  personaje con arma es la correcta"):
    caballero.SlotArma = Some(new Espada("Filo", 25, 8, caballero))
    assert(turnos.maxbarraDe(caballero) == 74.0)

  test("unidad agregada empieza barra en 0"):
    turnos.agregarUnidad(liviano)
    assert(turnos.barraDe(liviano) == 0.0)

  test("aumentos acumulan"):
    turnos.agregarUnidad(liviano)
    turnos.aumentarBarras(3)
    turnos.aumentarBarras(4)
    assert(turnos.barraDe(liviano) == 7.0)

  test("aumentar sin unidades no falla"):
    turnos.aumentarBarras(5)
    assert(turnos.unidadesEnBatalla.isEmpty)

  test("unidad agregada después de aumento empieza con 0"):
    turnos.agregarUnidad(liviano)
    turnos.aumentarBarras(5)
    turnos.agregarUnidad(pesado)
    assert(turnos.barraDe(pesado) == 0.0)

  test("reiniciar deja barra en 0 sin afectar alresto"):
    turnos.agregarUnidad(liviano)
    turnos.agregarUnidad(pesado)
    turnos.aumentarBarras(6)
    turnos.reiniciarBarra(liviano)
    assert(turnos.barraDe(liviano) == 0.0)
    assert(turnos.barraDe(pesado) == 6.0)

  test("sin unidades nadie tiene turno"):
    assert(turnos.unidadConTurno == None)

  test("nadie completó su barra nadie tiene turno"):
    turnos.agregarUnidad(liviano)
    turnos.aumentarBarras(9.9)
    assert(turnos.unidadConTurno == None)

  test("Una barra exactamente llena cuenta como completa"):
    turnos.agregarUnidad(liviano)
    turnos.aumentarBarras(10)
    assert(turnos.unidadConTurno == Some(liviano))

  test("turno de única unidad, la de mayor excedente"):
    turnos.agregarUnidad(pesado)
    turnos.agregarUnidad(liviano)
    turnos.aumentarBarras(45)   // excedentes: pesado 5, liviano 35
    assert(turnos.unidadConTurno == Some(liviano))

  test("unidades listas reciben turno por excedente decreciente"):
    turnos.agregarUnidad(pesado)
    turnos.agregarUnidad(liviano)
    turnos.aumentarBarras(45)
    assert(turnos.unidadConTurno == Some(liviano))
    turnos.reiniciarBarra(liviano)
    assert(turnos.unidadConTurno == Some(pesado))
    turnos.reiniciarBarra(pesado)
    assert(turnos.unidadConTurno == None)

  test("ersonajes y enemigos compiten por turno"):
    turnos.agregarUnidad(caballero)
    turnos.agregarUnidad(pesado)
    turnos.aumentarBarras(75)   // excedentes: caballero 5, pesado 35
    assert(turnos.unidadConTurno == Some(pesado))
    turnos.reiniciarBarra(pesado)
    assert(turnos.unidadConTurno == Some(caballero))

  test("en empate, turno,es de unidad agregada primero"):
    val otro = new Enemigos("D", 30, 1, 10, 3)   // misma barra máxima que liviano
    turnos.agregarUnidad(liviano)
    turnos.agregarUnidad(otro)
    turnos.aumentarBarras(15)
    assert(turnos.unidadConTurno == Some(liviano))

  test("unidad quitada no recibe turno"):
    turnos.agregarUnidad(liviano)
    turnos.aumentarBarras(20)
    turnos.quitarUnidad(liviano)
    assert(turnos.unidadConTurno == None)