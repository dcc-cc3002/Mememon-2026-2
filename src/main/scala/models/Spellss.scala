package cl.uchile.dcc
package models

abstract class SpellAction(val cost: Int) extends Action {
  def validateAndGetMage(source: AbsCharacter): AbsMagicianCharacter = source match {
    case mage: AbsMagicianCharacter =>
      require(mage.hp > 0, "Una unidad debe tener HP positivo para realizar una acción.")
      require(mage.mana >= cost, "Un personaje mágico debe cumplir con los puntos de maná necesario al momento de castear un hechizo.")
      require(mage.equippedWeapon.exists(_.isInstanceOf[MagicWeapon]), "Un personaje mágico además debe tener un arma mágica para poder realizar hechizos.")
      mage
    case _ =>
      require(false, "Solo los personajes mágicos pueden lanzar hechizos.")
      null 
  }
}

class HealAction extends SpellAction(cost = 15) {
  override def id: String = "heal"
  override def executeByCharacter(source: AbsCharacter, target: Target): Boolean = {
    val mage = validateAndGetMage(source)
    target.receiveHeal(this, mage)
  }
  override def executeByEnemy(source: Enemy, target: Target): Boolean = false
}

class PurifyAction extends SpellAction(cost = 25) {
  override def id: String = "purify"
  override def executeByCharacter(source: AbsCharacter, target: Target): Boolean = {
    val mage = validateAndGetMage(source)
    target.receivePurify(this, mage)
  }
  override def executeByEnemy(source: Enemy, target: Target): Boolean = false
}