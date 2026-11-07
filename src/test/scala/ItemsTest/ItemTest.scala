package cl.uchile.dcc
package ItemsTest

import Units.{Archer, BlackWizard, Knight, Thief, WhiteWizard}
import Items.*
import munit.FunSuite

class ItemTest extends FunSuite{
  test("Potion init works"){
    val HealingPotionTest = new HealingPotion("Abrilar")
    assertEquals(HealingPotionTest.Name,"Abrilar")
    val StrengthPotionTest = new StrengthPotion("Coke")
    assertEquals(StrengthPotionTest.Name,"Coke")
    val ManaPotionTest = new ManaPotion("Uwu's water")
    assertEquals(ManaPotionTest.Name,"Uwu's water")
    val MagicStrengthPotionTest = new MagicStrengthPotion("Monster")
    assertEquals(MagicStrengthPotionTest.Name,"Monster")
  }
  test("Weapon init works"){
    val KnightTest = new Knight(10,10,10) //I initialized everything to preserve the rule about characters and their respective weapons
    val ArcherTest = new Archer(15,15,15)
    val ThiefTest = new Thief(20,20,20)
    val BlackWizardTest = new BlackWizard(25,25,25,25)
    val WhiteWizardTest = new WhiteWizard(30,30,30,30)
    val StaffTest = new Staff(5,5,WhiteWizardTest,5)
    assertEquals(StaffTest.Name,"Staff")
    assertEquals(StaffTest.Weight,5)
    assertEquals(StaffTest.ATKPoints,5)
    assertEquals(StaffTest.Owner,WhiteWizardTest)
    assertEquals(StaffTest.MagicATKPoints,5)
    val WandTest = new Wand(6,6,BlackWizardTest,6)
    assertEquals(WandTest.Name,"Wand")
    assertEquals(WandTest.Weight,6)
    assertEquals(WandTest.ATKPoints,6)
    assertEquals(WandTest.Owner,BlackWizardTest)
    assertEquals(WandTest.MagicATKPoints,6)
    val SwordTest = new Sword(7,7,KnightTest)
    assertEquals(SwordTest.Name,"Sword")
    assertEquals(SwordTest.Weight,7)
    assertEquals(SwordTest.ATKPoints,7)
    assertEquals(SwordTest.Owner,KnightTest)
    val BowTest = new Bow(8,8,ArcherTest)
    assertEquals(BowTest.Name,"Bow")
    assertEquals(BowTest.Weight,8)
    assertEquals(BowTest.ATKPoints,8)
    assertEquals(BowTest.Owner,ArcherTest)
    val DaggerTest = new Dagger(9,9,ThiefTest)
    assertEquals(DaggerTest.Name,"Dagger")
    assertEquals(DaggerTest.Weight,9)
    assertEquals(DaggerTest.ATKPoints,9)
    assertEquals(DaggerTest.Owner,ThiefTest)
  }

}
