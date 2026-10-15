package cl.uchile.dcc
package UnitsTest

import Units.Enemy
import munit.FunSuite

class EnemyTest extends FunSuite {
  test("Enemy init works"){
    val EnemyTest = new Enemy("Balrog",10,10,10,10)
    assertEquals(EnemyTest.Name,"Balrog")
    assertEquals(EnemyTest.ATK,10)
    assertEquals(EnemyTest.Defense,10)
    assertEquals(EnemyTest.HP,10)
    assertEquals(EnemyTest.Weight,10)
  }
}
