package acciones

import utilizables.{Espada,Daga}
import unidades.Caballero

class EquiparArmaTest extends munit.FunSuite:
  test("equipararma built with name and list"):
    val owner = new Caballero("arthur", 100,15,70)
    val sword = new Espada("A", 25, 3,owner)
    val dagger = new Daga("B", 15,1,owner)
    val accion = new EquiparArma("C", List(sword, dagger))
    assertEquals(accion.nombre, "C")
    assertEquals(accion.PosibleObjects, List(sword, dagger))