package cl.uchile.dcc
package ItemsTest

import cl.uchile.dcc.Characters.{Archer, BlackWizard, Knight, Thief, WhiteWizard}
import cl.uchile.dcc.Items.*
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
    val KnightTest = new Knight("MegaKnight",10,10,10) //I initialized everything to preserve the rule about characters and their respective weapons
    val ArcherTest = new Archer("Legolas",15,15,15)
    val ThiefTest = new Thief("Michael",20,20,20)
    val BlackWizardTest = new BlackWizard("Voldemort",25,25,25,25)
    val WhiteWizardTest = new WhiteWizard("Gandalf",30,30,30,30)
    val StaffTest = new Staff("Gandalf´s Staff",5,5,WhiteWizardTest,5)
    assertEquals(StaffTest.Name,"Gandalf´s Staff")
    assertEquals(StaffTest.Weight,5)
    assertEquals(StaffTest.PhysicalATKPoints,5)
    assertEquals(StaffTest.Owner,WhiteWizardTest)
    assertEquals(StaffTest.MagicATKPoints,5)
    val WandTest = new Wand("Voldemort´s Wand",6,6,BlackWizardTest,6)
    assertEquals(WandTest.Name,"Voldemort´s Wand")
    assertEquals(WandTest.Weight,6)
    assertEquals(WandTest.PhysicalATKPoints,6)
    assertEquals(WandTest.Owner,BlackWizardTest)
    assertEquals(WandTest.MagicATKPoints,6)
    val SwordTest = new Sword("Excalibur",7,7,KnightTest)
    assertEquals(SwordTest.Name,"Excalibur")
    assertEquals(SwordTest.Weight,7)
    assertEquals(SwordTest.PhysicalATKPoints,7)
    assertEquals(SwordTest.Owner,KnightTest)
    val BowTest = new Bow("Just some bow",8,8,ArcherTest)
    assertEquals(BowTest.Name,"Just some bow")
    assertEquals(BowTest.Weight,8)
    assertEquals(BowTest.PhysicalATKPoints,8)
    assertEquals(BowTest.Owner,ArcherTest)
    val DaggerTest = new Dagger("Lol xd",9,9,ThiefTest)
    assertEquals(DaggerTest.Name,"Lol xd")
    assertEquals(DaggerTest.Weight,9)
    assertEquals(DaggerTest.PhysicalATKPoints,9)
    assertEquals(DaggerTest.Owner,ThiefTest)
  }

}
