package cl.uchile.dcc
package ActionTest


import Actions.{attack, consumePotion, equipWeapon, heal, meteorite, move, purification, thunder}
import Items.{HealingPotion, Item, Sword}
import Units.Knight

import munit.FunSuite

import scala.collection.mutable.ListBuffer

class actionTest extends FunSuite{
  test("Action innit works"){
    val MoveTest = new move()
    assertEquals(MoveTest.Name,"Move")
    val AttackTest = new attack()
    assertEquals(AttackTest.Name,"Attack")
    val MeteoriteTest = new meteorite()
    assertEquals(MeteoriteTest.Name,"Meteorite")
    val HealTest = new heal()
    assertEquals(HealTest.Name,"Heal")
    val ThunderTest = new thunder()
    assertEquals(ThunderTest.Name,"Thunder")
    val PurificationTest = new purification()
    assertEquals(PurificationTest.Name,"Purification")
    val EquipWeaponTest = new equipWeapon()
    assertEquals(EquipWeaponTest.Name,"EquipWeapon")
    val ConsumePotionTest = new consumePotion()
    assertEquals(ConsumePotionTest.Name,"ConsumePotion")
  }

}
