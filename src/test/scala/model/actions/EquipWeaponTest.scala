package cl.uchile.dcc
package model.actions

import model.units.{Archer, BlackWizard, Enemy, Knight, Thief, WhiteWizard}
import model.usable.{Bow, Dagger, Staff, Sword, Wand, Weapon}

class EquipWeaponTest extends munit.FunSuite:
  def newSword(): Weapon = new Sword("Sword", 30, 10, None)
  def newDagger(): Weapon = new Dagger("Dagger", 20, 4, None)
  def newBow(): Weapon = new Bow("Bow", 25, 6, None)
  def newWand(): Weapon = new Wand("Wand", 5, 2, None, 30)
  def newStaff(): Weapon = new Staff("Staff", 10, 8, None, 40)

  // Partition tests
  test("A knight can equip swords, daggers and bows, but not wands or staves"):
    val sword = newSword()
    val dagger = newDagger()
    val bow = newBow()
    val wand = newWand()
    val staff = newStaff()
    val character = new Knight("Juan", 100, 10, 50, None, List(sword, dagger, bow, wand, staff))
    assertEquals(character.doAction(new EquipWeapon("Equip", List(sword)), character), true)
    assertEquals(character.doAction(new EquipWeapon("Equip", List(dagger)), character), true)
    assertEquals(character.doAction(new EquipWeapon("Equip", List(bow)), character), true)
    assertEquals(character.doAction(new EquipWeapon("Equip", List(wand)), character), false)
    assertEquals(character.doAction(new EquipWeapon("Equip", List(staff)), character), false)

  test("An archer can equip swords, bows and wands, but not daggers or staves"):
    val sword = newSword()
    val dagger = newDagger()
    val bow = newBow()
    val wand = newWand()
    val staff = newStaff()
    val character = new Archer("Pedro", 100, 10, 50, None, List(sword, dagger, bow, wand, staff))
    assertEquals(character.doAction(new EquipWeapon("Equip", List(sword)), character), true)
    assertEquals(character.doAction(new EquipWeapon("Equip", List(dagger)), character), false)
    assertEquals(character.doAction(new EquipWeapon("Equip", List(bow)), character), true)
    assertEquals(character.doAction(new EquipWeapon("Equip", List(wand)), character), true)
    assertEquals(character.doAction(new EquipWeapon("Equip", List(staff)), character), false)

  test("A thief can equip swords and daggers, but not bows, wands or staves"):
    val sword = newSword()
    val dagger = newDagger()
    val bow = newBow()
    val wand = newWand()
    val staff = newStaff()
    val character = new Thief("Diego", 100, 10, 50, None, List(sword, dagger, bow, wand, staff))
    assertEquals(character.doAction(new EquipWeapon("Equip", List(sword)), character), true)
    assertEquals(character.doAction(new EquipWeapon("Equip", List(dagger)), character), true)
    assertEquals(character.doAction(new EquipWeapon("Equip", List(bow)), character), false)
    assertEquals(character.doAction(new EquipWeapon("Equip", List(wand)), character), false)
    assertEquals(character.doAction(new EquipWeapon("Equip", List(staff)), character), false)

  test("A black wizard can equip daggers, wands and staves, but not swords or bows"):
    val sword = newSword()
    val dagger = newDagger()
    val bow = newBow()
    val wand = newWand()
    val staff = newStaff()
    val character = new BlackWizard("Merlin", 100, 10, 50, None, List(sword, dagger, bow, wand, staff), 100)
    assertEquals(character.doAction(new EquipWeapon("Equip", List(sword)), character), false)
    assertEquals(character.doAction(new EquipWeapon("Equip", List(dagger)), character), true)
    assertEquals(character.doAction(new EquipWeapon("Equip", List(bow)), character), false)
    assertEquals(character.doAction(new EquipWeapon("Equip", List(wand)), character), true)
    assertEquals(character.doAction(new EquipWeapon("Equip", List(staff)), character), true)

  test("A white wizard can equip bows, wands and staves, but not swords or daggers"):
    val sword = newSword()
    val dagger = newDagger()
    val bow = newBow()
    val wand = newWand()
    val staff = newStaff()
    val character = new WhiteWizard("Gandalf", 100, 10, 50, None, List(sword, dagger, bow, wand, staff), 100)
    assertEquals(character.doAction(new EquipWeapon("Equip", List(sword)), character), false)
    assertEquals(character.doAction(new EquipWeapon("Equip", List(dagger)), character), false)
    assertEquals(character.doAction(new EquipWeapon("Equip", List(bow)), character), true)
    assertEquals(character.doAction(new EquipWeapon("Equip", List(wand)), character), true)
    assertEquals(character.doAction(new EquipWeapon("Equip", List(staff)), character), true)

  test("A weapon that cannot be equipped does not replace the current one"):
    val sword = newSword()
    val wand = newWand()
    val knight = new Knight("Juan", 100, 10, 50, None, List(sword, wand))
    knight.doAction(new EquipWeapon("Equip", List(sword)), knight)
    knight.doAction(new EquipWeapon("Equip", List(wand)), knight)
    assertEquals(knight.weapon, Some(sword))

  test("Equipping a weapon makes the character its owner"):
    val sword = newSword()
    val knight = new Knight("Juan", 100, 10, 50, None, List(sword))
    knight.doAction(new EquipWeapon("Equip", List(sword)), knight)
    assertEquals(sword.owner, Some(knight))

  test("Equipping a new weapon replaces the old one, which loses its owner"):
    val sword = newSword()
    val dagger = newDagger()
    val knight = new Knight("Juan", 100, 10, 50, None, List(sword, dagger))
    knight.doAction(new EquipWeapon("Equip", List(sword)), knight)
    knight.doAction(new EquipWeapon("Equip", List(dagger)), knight)
    assertEquals(knight.weapon, Some(dagger))
    assertEquals(sword.owner, None)
    assertEquals(dagger.owner, Some(knight))

  test("The action equips the last weapon of its list"):
    val sword = newSword()
    val dagger = newDagger()
    val knight = new Knight("Juan", 100, 10, 50, None, List(sword, dagger))
    knight.doAction(new EquipWeapon("Equip", List(sword, dagger)), knight)
    assertEquals(knight.weapon, Some(dagger))

  test("An enemy cannot equip a weapon"):
    val enemy = new Enemy("Goblin", 100, 25, 10, 40)
    assertEquals(enemy.doAction(new EquipWeapon("Equip", List(newSword())), enemy), false)

