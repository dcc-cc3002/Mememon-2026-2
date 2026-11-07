package cl.uchile.dcc
package model.actions

class ActionWithUsableTest extends munit.FunSuite:
  var equipWeapon: Option[ActionWithUsable] = None
  var consumePotion: Option[ActionWithUsable] = None

  override def beforeEach(context: BeforeEach): Unit = {
    equipWeapon = Some(new EquipWeapon("Knife", Nil))
    consumePotion = Some(new ConsumePotion("Fortitude", Nil))
  }

  test("EquipWeapon fulfills the ActionWithUsable"):
    val e = equipWeapon.get
    assertEquals(e.name, "Knife")
    assertEquals(e.objects, Nil)

  test("ConsumePotion fulfills the ActionWithUsable"):
    val c = consumePotion.get
    assertEquals(c.name, "Fortitude")
    assertEquals(c.objects, Nil)

