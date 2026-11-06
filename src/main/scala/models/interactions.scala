package cl.uchile.dcc
package models

trait Target:
  def receiveAttackFromCharacter(action: AttackAction, source: AbsCharacter): Boolean
  def receiveAttackFromEnemy(action: AttackAction, source: Enemy): Boolean
  def receiveEquipFromCharacter(action: EquipAction, source: AbsCharacter): Boolean
  def receiveEquipFromEnemy(action: EquipAction, source: Enemy): Boolean
  def receiveHeal(action: HealAction, source: AbsMagicianCharacter): Boolean
  def receivePurify(action: PurifyAction, source: AbsMagicianCharacter): Boolean

trait Source:
  def name: String
  def availableActions: List[Action]

  def getAction(actionId: String): Option[Action] =
    availableActions.find(_.id == actionId)

  def doAction(action: Action, target: Target): Boolean

trait Action:
  def id: String
  def executeByCharacter(source: AbsCharacter, target: Target): Boolean
  def executeByEnemy(source: Enemy, target: Target): Boolean