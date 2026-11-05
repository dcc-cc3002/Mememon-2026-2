package cl.uchile.dcc
package model.usable

import model.units.Character

trait Weapon extends usableCommon {
  def attack: Int
  def weight: Int
  def owner: Option[Character]
}

