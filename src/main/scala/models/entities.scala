package cl.uchile.dcc
package models

trait Entity:
  def name: String
  def hp: Int
  def defense: Int
  def weight: Int

abstract class EntityAttributes(val name: String, var hp: Int, val defense: Int, val weight: Int) extends Entity

abstract class AbsCharacter(name: String, initialHp: Int, defense: Int, weight: Int) extends EntityAttributes(name, initialHp, defense, weight) with Source with Target:
  var inventory: List[Potion] = List()
  var equippedWeapon: Option[Weapon] = None
  var availableActions: List[Action] = List(new AttackAction())
  var currentPanel: Option[Panel] = None

  def canEquip(weapon: Weapon): Boolean

  override def doAction(action: Action, target: Target): Boolean =
    if availableActions.exists(_.id == action.id) then
      action.executeByCharacter(this, target)
    else
      false

  override def receiveAttackFromEnemy(action: AttackAction, source: Enemy): Boolean = {
    require(this.hp > 0, "Una unidad que está derrotada no puede recibir acciones.")
    if (this.hp <= 0) return false
    val damage = source.attack - this.defense
    this.hp = math.max(0, this.hp - damage)
    return true
  }

  override def receiveAttackFromCharacter(action: AttackAction, source: AbsCharacter): Boolean = false

  override def receiveEquipFromCharacter(action: EquipAction, source: AbsCharacter): Boolean = {
    require(this.hp > 0, "Una unidad derrotada no puede equipar armas.")
    require(this.canEquip(action.weaponToEquip), "El personaje no puede equiparse este tipo de arma.")

    if (this == source) {
      this.equippedWeapon = Some(action.weaponToEquip)
      true
    } else false
  }

  override def receiveEquipFromEnemy(action: EquipAction, source: Enemy): Boolean = false

  override def receiveHeal(action: HealAction, source: AbsMagicianCharacter): Boolean = {
    require(this.hp > 0, "Una unidad derrotada no puede recibir acciones.")
    true
  }

  override def receivePurify(action: PurifyAction, source: AbsMagicianCharacter): Boolean = {
    require(false, "Purificación debe ser recibida únicamente por enemigos.")
    false
  }

abstract class AbsMagicianCharacter(name: String, hp: Int, defense: Int, weight: Int, var mana: Int) extends AbsCharacter(name, hp, defense, weight)

class Enemy(name: String, initialHp: Int, defense: Int, weight: Int, val attack: Int) extends EntityAttributes(name, initialHp, defense, weight) with Source with Target:
  var currentPanel: Option[Panel] = None
  var availableActions: List[Action] = List(new AttackAction())

  override def doAction(action: Action, target: Target): Boolean =
    if availableActions.exists(_.id == action.id) then
      action.executeByEnemy(this, target)
    else
      false

  override def receiveAttackFromCharacter(action: AttackAction, source: AbsCharacter): Boolean = {
    require(this.hp > 0, "Una unidad que está derrotada no puede recibir acciones.")
    if (this.hp <= 0)
      return false

    val attackPower = source.equippedWeapon match {
      case Some(weapon) => weapon.attackPoints
      case None => 0
    }

    val damage = attackPower - this.defense
    this.hp = math.max(0, this.hp - damage)
    return true
  }

  override def receiveHeal(action: HealAction, source: AbsMagicianCharacter): Boolean = {
    require(false, "Curación debe ser recibida únicamente por personajes.")
    false
  }

  override def receivePurify(action: PurifyAction, source: AbsMagicianCharacter): Boolean = {
    require(this.hp > 0, "Una unidad derrotada no puede recibir acciones.")
    true
  }
  override def receiveAttackFromEnemy(action: AttackAction, source: Enemy): Boolean = false
  override def receiveEquipFromCharacter(action: EquipAction, source: AbsCharacter): Boolean = false
  override def receiveEquipFromEnemy(action: EquipAction, source: Enemy): Boolean = false

class Knight(name: String, hp: Int, defense: Int, weight: Int) extends AbsCharacter(name, hp, defense, weight) {
  override def canEquip(weapon: Weapon): Boolean = weapon match {
    case _: Sword => true
    case _ => false
  }
}

class Archer(name: String, hp: Int, defense: Int, weight: Int) extends AbsCharacter(name, hp, defense, weight) {
  override def canEquip(weapon: Weapon): Boolean = weapon match {
    case _: Bow => true
    case _ => false
  }
}

class Thief(name: String, hp: Int, defense: Int, weight: Int) extends AbsCharacter(name, hp, defense, weight) {
  override def canEquip(weapon: Weapon): Boolean = weapon match {
    case _: Dagger => true
    case _: Sword => true // Si tu tabla dice que no usa espada, borra esta línea
    case _ => false
  }
}

class BlackMagician(name: String, hp: Int, defense: Int, weight: Int, mana: Int) extends AbsMagicianCharacter(name, hp, defense, weight, mana) {
  override def canEquip(weapon: Weapon): Boolean = weapon match {
    case _: Wand => true
    case _: MagicStaff => true
    case _ => false
  }
}

class WhiteMagician(name: String, hp: Int, defense: Int, weight: Int, mana: Int) extends AbsMagicianCharacter(name, hp, defense, weight, mana) {
  override def canEquip(weapon: Weapon): Boolean = weapon match {
    case _: Wand => true
    case _: MagicStaff => true
    case _ => false
  }
}

class Player(var playerUnits: List[AbsCharacter] = List()):
  def isDefeated: Boolean =
    playerUnits.forall(character => character.hp <= 0)

trait Armament:
  def weaponName: String
  def attackPoints: Int
  def weaponWeight: Int
  def owner: AbsCharacter

abstract class Weapon(val weaponName: String, var attackPoints: Int, val weaponWeight: Int, var owner: AbsCharacter) extends Armament

abstract class MagicWeapon(weaponName: String, attackPoints: Int, weaponWeight: Int, owner: AbsCharacter, var magicPoints: Int) extends Weapon(weaponName, attackPoints, weaponWeight, owner)

class Sword(weaponName: String, attackPoints: Int, weaponWeight: Int, owner: AbsCharacter) extends Weapon(weaponName, attackPoints, weaponWeight, owner)
class Dagger(weaponName: String, attackPoints: Int, weaponWeight: Int, owner: AbsCharacter) extends Weapon(weaponName, attackPoints, weaponWeight, owner)
class Bow(weaponName: String, attackPoints: Int, weaponWeight: Int, owner: AbsCharacter) extends Weapon(weaponName, attackPoints, weaponWeight, owner)

class Wand(weaponName: String, attackPoints: Int, weaponWeight: Int, owner: AbsCharacter, magicPoints: Int) extends MagicWeapon(weaponName, attackPoints, weaponWeight, owner, magicPoints)
class MagicStaff(weaponName: String, attackPoints: Int, weaponWeight: Int, owner: AbsCharacter, magicPoints: Int) extends MagicWeapon(weaponName, attackPoints, weaponWeight, owner, magicPoints)

trait Effect:
  def name: String

abstract class Potion(val name: String) extends Effect

class HealthPotion(name: String) extends Potion(name)
class StrengthPotion(name: String) extends Potion(name)
class ManaPotion(name: String) extends Potion(name)
class MagicStrengthPotion(name: String) extends Potion(name)