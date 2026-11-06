package cl.uchile.dcc
package model.units

class CharacterTest extends munit.FunSuite {
  test("El caballero tiene los atributos correctos"){
    val knight = new Knight("Caballero", 100, 25, 15)

    assertEquals(knight.name, "Caballero")
    assertEquals(knight.healthPoints, 100)
    assertEquals(knight.defensePoints, 25)
    assertEquals(knight.weight, 15)
  }
  
  
}