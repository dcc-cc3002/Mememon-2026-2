package cl.uchile.dcc
package ActionTest


import Actions.{Attack, ConsumePotion, EquipWeapon, Heal, Meteorite, Move, Purification, Thunder}
import Items.{HealingPotion, Item, Sword}
import Units.Knight
import munit.FunSuite

import scala.collection.mutable.ListBuffer

class ActionTest extends FunSuite{
  test("Action innit works"){
    val MoveTest = new Move("Move")
    assertEquals(MoveTest.Name,"Move")
    val AttackTest = new Attack("Attack")
    assertEquals(AttackTest.Name,"Attack")
    val MeteoriteTest = new Meteorite("Meteorite")
    assertEquals(MeteoriteTest.Name,"Meteorite")
    val HealTest = new Heal("Heal")
    assertEquals(HealTest.Name,"Heal")
    val ThunderTest = new Thunder("Thunder")
    assertEquals(ThunderTest.Name,"Thunder")
    val PurificationTest = new Purification("Purification")
    assertEquals(PurificationTest.Name,"Purification")

    //EquipWeapon Test
    val GenericKnight = new Knight("Lancelot",10,10,10)
    val GenericSword = new Sword("Excalibur",10,10,GenericKnight)
    val EquipWeaponTest = new EquipWeapon("EquipWeapon",GenericSword)
    assertEquals(EquipWeaponTest.Name,"EquipWeapon")
    assertEquals(EquipWeaponTest.weapon.Name,"Excalibur")
    assertEquals(EquipWeaponTest.weapon.PhysicalATKPoints,10)
    assertEquals(EquipWeaponTest.weapon.Weight,10)
    assertEquals(EquipWeaponTest.weapon.Owner.Name,"Lancelot")
    assertEquals(EquipWeaponTest.weapon.Owner.HP,10)
    assertEquals(EquipWeaponTest.weapon.Owner.Defense,10)
    assertEquals(EquipWeaponTest.weapon.Owner.Weight,10)
    assertEquals(EquipWeaponTest.Allowed,ListBuffer[Item]())

    //ConsumePotion Test
    val GenericPotion = new HealingPotion("Healing Potion")
    val ConsumePotionTest = new ConsumePotion("MyHealingPotion",GenericPotion)
    assertEquals(ConsumePotionTest.Name,"MyHealingPotion")
    assertEquals(ConsumePotionTest.potion.Name,"Healing Potion")

  }

}
