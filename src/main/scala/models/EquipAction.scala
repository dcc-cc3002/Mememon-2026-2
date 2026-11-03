package cl.uchile.dcc
package models

class EquipAction(val weaponToEquip: Weapon) extends Action:
  override def id: String = "equip"

  override def executeByCharacter(source: AbsCharacter, target: Target): Boolean =
    target.receiveEquipFromCharacter(this, source)

  override def executeByEnemy(source: Enemy, target: Target): Boolean =
    target.receiveEquipFromEnemy(this, source)
