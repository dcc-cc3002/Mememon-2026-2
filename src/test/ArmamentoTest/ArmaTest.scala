package ArmamentoTest

import munit.FunSuite
import cl.uchile.dcc.Armamento.*
import cl.uchile.dcc.Personajes.*

class ArmamentoTest extends FunSuite:

  val owner = new Caballero("Arturo", 100, 20, 80)

  test("Una varita debe tener los atributos correctos") {
    val varita = new Varita("Varita", 10, 5, owner, 20)

    assertEquals(varita.nombre, "Varita")
    assertEquals(varita.PuntosDeAtaque, 10)
    assertEquals(varita.peso, 5)
    assertEquals(varita.owner, owner)
    assertEquals(varita.PuntosDeAtaqueMagico, 20)
  }

  test("Un bastón debe tener los atributos correctos") {
    val baston = new Baston("Baston", 15, 8, owner, 25)

    assertEquals(baston.nombre, "Baston")
    assertEquals(baston.PuntosDeAtaque, 15)
    assertEquals(baston.peso, 8)
    assertEquals(baston.owner, owner)
    assertEquals(baston.PuntosDeAtaqueMagico, 25)
  }

  test("Una espada debe tener los atributos correctos") {
    val espada = new Espada("Espada", 20, 10, owner, 0)

    assertEquals(espada.nombre, "Espada")
    assertEquals(espada.PuntosDeAtaque, 20)
    assertEquals(espada.peso, 10)
    assertEquals(espada.owner, owner)
  }

  test("Una daga debe tener los atributos correctos") {
    val daga = new Daga("Daga", 12, 4, owner, 0)

    assertEquals(daga.nombre, "Daga")
    assertEquals(daga.PuntosDeAtaque, 12)
    assertEquals(daga.peso, 4)
    assertEquals(daga.owner, owner)
  }

  test("Un arco debe tener los atributos correctos") {
    val arco = new Arco("Arco", 18, 7, owner, 0)

    assertEquals(arco.nombre, "Arco")
    assertEquals(arco.PuntosDeAtaque, 18)
    assertEquals(arco.peso, 7)
    assertEquals(arco.owner, owner)
  }