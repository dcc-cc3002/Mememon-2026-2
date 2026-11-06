package cl.uchile.dcc
package model.actions

import model.usable.{Weapon, Potion}

/** Contract for the entities that can perform actions (the units). */
trait Source {
  /** Performs an action on a target.
   *
   * The action decides which method of the source to call, the source decides
   * whether it can perform it, and the target applies the effect.
   *
   * @param action The action to perform.
   * @param target The entity that receives the action.
   * @return True if the action was performed successfully, false otherwise.
   */
  def doAction(action: ActionContract, target: Target): Boolean

  /** Returns the damage this source deals with a physical attack. */
  def attackDamage: Int
  /** Returns the damage of the spells cast by this source. */
  def magicDamage: Int

  /** Attacks the target. Returns true if the action succeeds. */
  def attackTo(target: Target): Boolean
  /** Moves to the target panel. Returns true if the action succeeds. */
  def moveTo(target: Target): Boolean
  /** Equips a weapon on the target. Returns true if the action succeeds. */
  def equipWeaponTo(target: Target, weapon: Weapon): Boolean
  /** Consumes a potion on the target. Returns true if the action succeeds. */
  def consumePotionTo(target: Target, potion: Potion): Boolean
  /** Casts Thunder on the target. Returns true if the action succeeds. */
  def thunderTo(target: Target): Boolean
  /** Casts Meteor on the target. Returns true if the action succeeds. */
  def meteorTo(target: Target): Boolean
  /** Casts Heal on the target. Returns true if the action succeeds. */
  def healTo(target: Target): Boolean
  /** Casts Purify on the target. Returns true if the action succeeds. */
  def purifyTo(target: Target): Boolean
}
