package cl.uchile.dcc
package model.units

import model.actions.Target
import model.usable.{Weapon, usableCommon}

/** A white wizard, a magic character that can cast Heal and Purify.
 *
 * It can equip: bows, wands, staves.
 *
 * @param name The name of the unit.
 * @param health The maximum health points of the unit.
 * @param defense The defense points the unit starts with.
 * @param weight The weight of the unit.
 * @param weapon The weapon the character starts with, if any.
 * @param utilities The inventory of usable items the character starts with.
 * @param mana The maximum mana points of the character.
 */
class WhiteWizard(name: String, health: Int, defense: Int, weight:
Int, weapon: Option[Weapon], utilities: List[usableCommon], mana: Int) extends AbstractMagicCharacter(name, health, defense, weight, weapon, utilities, mana) {
  private val healCost: Int = 15
  private val purifyCost: Int = 25

  override def healTo(target: Target): Boolean =
    if (hasEnoughMana(healCost) && target.receivesHeal(this)) {
      spendMana(healCost)
      true
    } 
    else {
      false
    }

  override def purifyTo(target: Target): Boolean =
    if (hasEnoughMana(purifyCost) && target.receivesPurify(this)) {
      spendMana(purifyCost)
      true
    }
    else {
      false
    }

  override def canEquipBow: Boolean = true
  override def canEquipWand: Boolean = true
  override def canEquipStaff: Boolean = true
}



