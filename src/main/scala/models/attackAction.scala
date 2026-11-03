package cl.uchile.dcc
package models

class AttackAction extends Action:
  override def id: String = "attack"

  override def executeByCharacter(source: AbsCharacter, target: Target): Boolean =
    target.receiveAttackFromCharacter(this, source)

  override def executeByEnemy(source: Enemy, target: Target): Boolean =
    target.receiveAttackFromEnemy(this, source)
