package cl.uchile.dcc
package TurnSchedulerTest

import TurnScheduler.turnScheduler

import cl.uchile.dcc.Units.{Knight, units}
import munit.FunSuite

import scala.collection.mutable.ListBuffer

class turnSchedulerTest extends FunSuite {
  
  test("TurnScheduler init Works"){
    val TST = new turnScheduler
    val RandomKnight = new Knight(10,10,10)
    assertEquals(TST.getUnitList,ListBuffer[units]())
    TST.PutUnit(RandomKnight)
    assertEquals(TST.GetUnit(0),RandomKnight)
    TST.AddAllBars(10)
    assert(TST.CompletedBar(TST.GetUnit(0)))
    assertEquals(TST.turn(),Some(RandomKnight))
    TST.ResetBar(TST.GetUnit(0))
    assert(!TST.CompletedBar(TST.GetUnit(0)))
    assertEquals(TST.turn(),None)

  }
  
}
