package cl.uchile.dcc
package models

class AttackAction extends Action:
  override def id: String = "attack"

  override def executeByCharacter(source: AbsCharacter, target: Target): Boolean = {
    require(source.hp > 0, "Una unidad debe tener HP positivo para realizar una acción.")
    require(source.equippedWeapon.isDefined, "Un personaje debe tener un arma para poder realizar un ataque.")
    target.receiveAttackFromCharacter(this, source)
  }

  override def executeByEnemy(source: Enemy, target: Target): Boolean =
    require(source.hp > 0, "Una unidad debe tener HP positivo para realizar una acción.")
    target.receiveAttackFromEnemy(this, source)
