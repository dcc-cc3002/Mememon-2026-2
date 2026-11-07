package cl.uchile.dcc
package UnitsTest

import Units.*
import munit.FunSuite

class characterTest extends FunSuite {
  test("Character init works"){
    val KnightTest = new Knight(10,10,10)
    assertEquals(KnightTest.Name,"Knight")
    assertEquals(KnightTest.HP,10)
    assertEquals(KnightTest.Defense,10)
    assertEquals(KnightTest.Weight,10)
    val ArcherTest = new Archer(15,15,15)
    assertEquals(ArcherTest.Name,"Archer")
    assertEquals(ArcherTest.HP,15)
    assertEquals(ArcherTest.Defense,15)
    assertEquals(ArcherTest.Weight,15)
    val ThiefTest = new Thief(20,20,20)
    assertEquals(ThiefTest.Name,"Thief")
    assertEquals(ThiefTest.HP,20)
    assertEquals(ThiefTest.Defense,20)
    assertEquals(ThiefTest.Weight,20)
    val BlackWizardTest = new BlackWizard(25,25,25,25)
    assertEquals(BlackWizardTest.Name,"BlackWizard")
    assertEquals(BlackWizardTest.HP,25)
    assertEquals(BlackWizardTest.Defense,25)
    assertEquals(BlackWizardTest.Weight,25)
    assertEquals(BlackWizardTest.ManaPoints,25)
    val WhiteWizardTest = new WhiteWizard(30,30,30,30)
    assertEquals(WhiteWizardTest.Name,"WhiteWizard")
    assertEquals(WhiteWizardTest.HP,30)
    assertEquals(WhiteWizardTest.Defense,30)
    assertEquals(WhiteWizardTest.Weight,30)
    assertEquals(WhiteWizardTest.ManaPoints,30)
  }


}