package cl.uchile.dcc
package CharacterTest

import cl.uchile.dcc.Characters.Enemy
import munit.FunSuite

class EnemyTest extends FunSuite {
  test("Enemy init works"){
    val EnemyTest = new Enemy("Balrog",10,10,10,10)
    assertEquals(EnemyTest.Name,"Balrog")
    assertEquals(EnemyTest.ATK,10)
    assertEquals(EnemyTest.Defense,10)
    assertEquals(EnemyTest.HealthPoints,10)
    assertEquals(EnemyTest.Weight,10)
  }
}
