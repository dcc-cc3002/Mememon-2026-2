package unidades

import utilizables.Espada
import unidades.Enemigos

class BarraAccionTest extends munit.FunSuite:
  var caballero: Caballero = null
  var enemigo :Enemigos = null
  
  override def beforeEach(context: BeforeEach): Unit =
    caballero = new Caballero("A", 100, 15, 70)
    enemigo = new Enemigos("B", 40, 10, 30, 20)
    
  test("personaje sin arma tiene barraccion igual a su peso"):
    assertEquals(caballero.BarraAccion, 70.0)
    
  test("Personaje con arma suma mitad peso de arma"):
    caballero.SlotArma = Some(new Espada("C", 25,8, caballero))
    assertEquals(caballero.BarraAccion, 70.0 +0.5*8)
    
  test("Enemigo tiene barraAccion igual a su peso"):
    assertEquals(enemigo.BarraAccion, 30.0)
  
  