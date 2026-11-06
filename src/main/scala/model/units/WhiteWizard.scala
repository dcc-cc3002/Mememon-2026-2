package cl.uchile.dcc
package model.units

import model.actions.Target
import model.usable.{Weapon, usableCommon}

/** A white wizard, a magic character.
 *
 * @param name The name of the unit.
 * @param health The health points of the unit.
 * @param defense The defense points of the unit.
 * @param weight The weight of the unit.
 * @param weapon The weapon equipped by the character, if any.
 * @param utilities The inventory of usable items of the character.
 * @param mana The mana points of the character.
 */
class WhiteWizard(name: String, health: Int, defense: Int, weight:
Int, weapon: Option[Weapon], utilities: List[usableCommon], mana: Int) extends AbstractMagicCharacter(name, health, defense, weight, weapon, utilities, mana) {
  private val healCost: Int = 15
  private val purifyCost: Int = 25

  override def healTo(target: Target): Boolean =
    mana >= healCost && target.receivesHeal(this)

  override def purifyTo(target: Target): Boolean =
    mana >= purifyCost && target.receivesPurify(this)
}



