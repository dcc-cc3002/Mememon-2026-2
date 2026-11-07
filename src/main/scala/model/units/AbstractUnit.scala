package cl.uchile.dcc
package model.units

import model.actions.{ActionContract, Attack, Move, Source, Target}
import model.usable.{Potion, Weapon}
import model.exceptions.InvalidActionException

/** Base class that stores the properties shared by all units.
 *
 * By default, a unit can attack, move, and receive attacks and Thunder.
 * Every other action fails, unless a subclass allows it.
 *
 * @param name The name of the unit.
 * @param maxHealth The maximum health points of the unit. The unit starts with this health.
 * @param initialDefense The defense points the unit starts with.
 * @param weight The weight of the unit.
 */
abstract class AbstractUnit(val name: String, val maxHealth: Int, val initialDefense: Int, val weight: Int) extends UnitsCommon {
  private var currentHealth: Int = maxHealth
  private var currentDefense: Int = initialDefense

  override def health: Int = currentHealth
  override def defense: Int = currentDefense

  override def takeDamage(amount: Int): Unit = {
    var damage = amount
    if (amount < 0) {
      damage = 0
    }
    val newHealth = currentHealth - damage
    if (newHealth < 0) {
      currentHealth = 0
    }
    else {
      currentHealth = newHealth
    }
  }

  /** Restores health points, without going above the maximum health.
   *
   * @param amount The health points to restore. Negative amounts are ignored.
   */
  protected def restoreHealth(amount: Int): Unit = {
    var healing = amount
    if (amount < 0) {
      healing = 0
    }
    val newHealth = currentHealth + healing
    if (newHealth > maxHealth) {
      currentHealth = maxHealth
    }
    else {
      currentHealth = newHealth
    }
  }

  /** Changes the defense points of the unit.
   *
   * @param newDefense The new defense points.
   */
  protected def changeDefense(newDefense: Int): Unit =
    currentDefense = newDefense

  
  override def actions: List[ActionContract] =
    List(new Attack("Attack"), new Move("Move"))
  
  
  // Source, entry point of the action system
  override def doAction(action: ActionContract, target: Target): Boolean = {
    if (health <= 0) {
      throw new InvalidActionException(s"$name is unable to perform ${action.name} since it has no health points")
    }
    action.execute(this, target)
  }

  override def attackTo(target: Target): Boolean =
    target.receivesAttack(this)

  override def moveTo(target: Target): Boolean =
    target.receivesMove(this)

  // Source, actions that fail unless a subclass allows
  override def equipWeaponTo(target: Target, weapon: Weapon): Boolean = false
  override def consumePotionTo(target: Target, potion: Potion): Boolean = false
  override def thunderTo(target: Target): Boolean = false
  override def meteorTo(target: Target): Boolean = false
  override def healTo(target: Target): Boolean = false
  override def purifyTo(target: Target): Boolean = false


  // Target, actions every unit can receive
  override def receivesAttack(source: Source): Boolean = {
    takeDamage(source.attackDamage - defense)
    true
  }

  override def receivesThunder(source: Source): Boolean = {
    takeDamage(source.magicDamage)
    true
  }

  // Target, actions that fail unless a subclass allows
  override def receivesMove(unit: UnitsCommon): Boolean = false
  override def receivesMeteor(source: Source): Boolean = false
  override def receivesEquipWeapon(source: Source, weapon: Weapon): Boolean = false
  override def receivesConsumePotion(source: Source, potion: Potion): Boolean = false
  override def receivesHeal(source: Source): Boolean = false
  override def receivesPurify(source: Source): Boolean = false
}

