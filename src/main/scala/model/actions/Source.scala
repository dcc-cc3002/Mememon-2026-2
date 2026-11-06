package cl.uchile.dcc
package model.actions

import model.usable.{Weapon, Potion}

trait Source {
  def doAction(action: ActionContract, target: Target): Boolean

  def attackTo(target: Target): Boolean
  def moveTo(target: Target): Boolean
  def equipWeaponTo(target: Target, weapon: Weapon): Boolean
  def consumePotionTo(target: Target, potion: Potion): Boolean
  def thunderTo(target: Target): Boolean
  def meteorTo(target: Target): Boolean
  def healTo(target: Target): Boolean
  def purifyTo(target: Target): Boolean
}
