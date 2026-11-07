package cl.uchile.dcc
package weapons.common

import cl.uchile.dcc.characters.commoncharacters.{Knight,Archer,Thief}
import weapons.Weapon

/**
 * A common class weapon that can be wielded by Knights, Archers and Thieves
 * @param name name of the weapon
 * @param attack attack points of the weapon
 * @param weight weight of the weapon
 *
 */

class Sword(val name: String, val attack: Double, val weight: Double) extends Weapon {

}
