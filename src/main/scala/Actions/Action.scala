package cl.uchile.dcc
package Actions

trait Action:
  def Attack(): Unit
  def Move(): Unit
  def EquipWeapon(): Unit
  def UsePotion(): Unit

trait MagicAction extends Action:
  def UseSpell(Spell: Spell): Unit
