package cl.uchile.dcc
package model.weapons

class WeaponTest extends munit.FunSuite {
  test("La espada tiene los atributos correctos"){
    val sword = new Sword("Espadín", 60, 10)
  }
}