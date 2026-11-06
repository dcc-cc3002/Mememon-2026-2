package cl.uchile.dcc
package model.actions

import model.usable.{Weapon, Potion}

trait Target {
  def receivesAttack(source: Source): Boolean
  def receivesMove(source: Source): Boolean
  def receivesEquipWeapon(source: Source, weapon: Weapon): Boolean
  def receivesConsumePotion(source: Source, potion: Potion): Boolean
  def receivesThunder(source: Source): Boolean
  def receivesMeteor(source: Source): Boolean
  def receivesHeal(source: Source): Boolean
  def receivesPurify(source: Source): Boolean
}
