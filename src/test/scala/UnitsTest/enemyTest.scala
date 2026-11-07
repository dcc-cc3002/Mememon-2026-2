package cl.uchile.dcc
package UnitsTest

import Units.enemy
import munit.FunSuite

class enemyTest extends FunSuite {
  test("Enemy init works"){
    val EnemyTest = new enemy(10,10,10,10)
    assertEquals(EnemyTest.Name,"Enemy")
    assertEquals(EnemyTest.ATK,10)
    assertEquals(EnemyTest.Defense,10)
    assertEquals(EnemyTest.HP,10)
    assertEquals(EnemyTest.Weight,10)
  }
}
