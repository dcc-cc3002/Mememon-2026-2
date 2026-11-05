package cl.uchile.dcc
package model.units

trait EnemiesContract extends UnitsCommon {
  def attack: Int
}

class Enemy(name: String, health: Int, val attack: Int, defense: Int, weight: Int) extends AbstractUnit(name, health, defense, weight) with EnemiesContract {
  override def maxActionBar: Double = weight
}
