package cl.uchile.dcc
package model.units

class UnitTest extends munit.FunSuite {
  test("El enemigo tiene los atributos correctos"){
    val enemy = new Enemy("Enemigo", 100, 15, 10, 5)

    assertEquals(enemy.name, "Enemigo")
    assertEquals(enemy.healthPoints, 100)
    assertEquals(enemy.attackPoints, 15)
    assertEquals(enemy.defensePoints, 10)
    assertEquals(enemy.weight, 5)
  }

}