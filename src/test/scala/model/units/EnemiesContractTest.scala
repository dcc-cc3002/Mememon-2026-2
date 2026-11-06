package cl.uchile.dcc
package model.units

class EnemiesContractTest extends munit.FunSuite:
  var enemy: Option[EnemiesContract] = None

  override def beforeEach(context: BeforeEach): Unit = {
    enemy = Some(new Enemy("Jose", 90, 100, 55, 120))
  }

  test("Enemy fulfills the EnemiesContract contract"):
    val e = enemy.get
    assertEquals(e.name, "Jose")
    assertEquals(e.health, 90)
    assertEquals(e.attack, 100)
    assertEquals(e.defense, 55)
    assertEquals(e.weight, 120)

  test("maxActionBar of an Enemy is its weight"):
    assertEquals(enemy.get.maxActionBar, 120.0)


  test("An enemy starts with its maximum health"):
    assertEquals(enemy.get.health, 90)
    assertEquals(enemy.get.maxHealth, 90)

  test("takeDamage reduces the current health but not the maximum"):
    enemy.get.takeDamage(30)
    assertEquals(enemy.get.health, 60)
    assertEquals(enemy.get.maxHealth, 90)

  test("takeDamage ignores negative amounts"):
    enemy.get.takeDamage(-20)
    assertEquals(enemy.get.health, 90)

  test("takeDamage never leaves the health below 0"):
    enemy.get.takeDamage(500)
    assertEquals(enemy.get.health, 0)

