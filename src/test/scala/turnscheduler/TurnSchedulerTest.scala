package cl.uchile.dcc
package turnscheduler

import cl.uchile.dcc.characters.commoncharacters.{Archer, Knight}
import cl.uchile.dcc.weapons.common.{Bow, Sword}
import cl.uchile.dcc.enemy.Enemy


/**Tests for TurnScheduler
 */

class TurnSchedulerTest extends munit.FunSuite {
  test("adding an unit"){
    val scheduler = new TurnScheduler()
    val enemy = new Enemy("Harpy", 80.0, 80.0, 50.0, 50.0, 30.0)
    /** verify that its action bar is empty*/
    assertEquals(scheduler.getActionBar(enemy), Option.empty[Double])
    /** adding the unit and action bar set to 0.0*/
    scheduler.addUnit(enemy)
    assertEquals(scheduler.getActionBar(enemy), Option(0.0))
  }

  test("removing an unit"){
    val scheduler = new TurnScheduler()
    val enemy = new Enemy("Harpy", 80.0, 80.0, 50.0, 50.0, 30.0)
    scheduler.addUnit(enemy)
    scheduler.removeUnit(enemy)
    assertEquals(scheduler.getActionBar(enemy), Option.empty[Double])
  }

  test("increase action bars of all units"){
    val scheduler = new TurnScheduler()
    val harpy = new Enemy("Harpy", 80.0, 80.0, 50.0, 50.0, 30.0)
    val orc = new Enemy("Orc", 100.0, 100.0, 120.0, 120.0, 100.0)

    scheduler.addUnit(harpy)
    scheduler.addUnit(orc)
    scheduler.increaseActionBar(3.0)
    assertEquals(scheduler.getActionBar(harpy), Some(3.0))
    assertEquals(scheduler.getActionBar(orc), Some(3.0))

    /** another increase to check if it sums up */
    scheduler.increaseActionBar(2.0)
    assertEquals(scheduler.getActionBar(harpy), Some(5.0))
    assertEquals(scheduler.getActionBar(orc), Some(5.0))
  }

  test("reset action bar of an unit"){
    val scheduler = new TurnScheduler()
    val archer = new Archer("Susan", 100.0, 100.0, 80.0, 50.0)
    val knight = new Knight("Peter", 100.0, 80.0, 90.0, 90.0)
    val sword = new Sword("Sword", 15.0, 4.0)
    val bow = new Bow("Bow", 12.0, 2.0)

    scheduler.addUnit(archer)
    scheduler.addUnit(knight)

    scheduler.increaseActionBar(4.0)
    scheduler.resetActionBar(knight)
    assertEquals(scheduler.getActionBar(archer), Some(4.0))
    assertEquals(scheduler.getActionBar(knight), Some(0.0))
  }

  test("scheduler can assert turn priority between characters"){
    val archer = new Archer("Susan", 100.0, 100.0, 80.0, 50.0)
    val knight = new Knight("Peter", 100.0, 80.0, 90.0, 90.0)
    val sword = new Sword("Sword", 15.0, 4.0)
    val bow = new Bow("Bow", 12.0, 2.0)
    knight.equipWeapon(sword)
    archer.equipWeapon(bow)

    assertEquals(knight.equippedWeapon, Some(sword))
    assertEquals(archer.equippedWeapon, Some(bow))

    val scheduler = new TurnScheduler()
    scheduler.addUnit(knight)
    scheduler.addUnit(archer)
    scheduler.increaseActionBar(90.0)
    assertEquals(scheduler.turnUnit, Some(archer))
  }

  test("scheduler can assert priority between enemies"){
    val scheduler = new TurnScheduler()
    val harpy = new Enemy("Harpy", 80.0, 80.0, 50.0, 50.0, 30.0)
    val orc = new Enemy("Orc", 100.0, 100.0, 120.0, 120.0, 100.0)

    scheduler.addUnit(harpy)
    scheduler.addUnit(orc)
    scheduler.increaseActionBar(125.0)
    assertEquals(scheduler.turnUnit, Some(harpy))
  }

  test("scheduler can assert priority between an unit with a weapon and one without"){
    val scheduler = new TurnScheduler()
    val harpy = new Enemy("Harpy", 80.0, 80.0, 50.0, 50.0, 30.0)
    val archer = new Archer("Susan", 100.0, 100.0, 50.0, 40.0)
    val bow = new Bow("Bow", 12.0, 2.0)
    archer.equipWeapon(bow)

    scheduler.addUnit(harpy)
    scheduler.addUnit(archer)
    scheduler.increaseActionBar(60.0)
    assertEquals(scheduler.turnUnit, Some(archer))
  }
}
