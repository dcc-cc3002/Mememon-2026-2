package cl.uchile.dcc
package model.actions

import model.units.UnitsCommon
import model.usable.{Weapon, Potion}

/** Contract for the entities that can receive actions (units and panels). */
trait Target {
  /** Receives an attack from the source. Returns true if the effect is applied. */
  def receivesAttack(source: Source): Boolean
  /** Receives a unit that moves into it. Returns true if the effect is applied. */
  def receivesMove(unit: UnitsCommon): Boolean
  /** Receives a weapon to equip. Returns true if the effect is applied. */
  def receivesEquipWeapon(source: Source, weapon: Weapon): Boolean
  /** Receives a potion to consume. Returns true if the effect is applied. */
  def receivesConsumePotion(source: Source, potion: Potion): Boolean
  /** Receives a Thunder spell from the source. Returns true if the effect is applied. */
  def receivesThunder(source: Source): Boolean
  /** Receives a Meteor spell from the source. Returns true if the effect is applied. */
  def receivesMeteor(source: Source): Boolean
  /** Receives a Heal spell from the source. Returns true if the effect is applied. */
  def receivesHeal(source: Source): Boolean
  /** Receives a Purify spell from the source. Returns true if the effect is applied. */
  def receivesPurify(source: Source): Boolean
}
