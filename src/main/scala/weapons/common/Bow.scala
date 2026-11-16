package cl.uchile.dcc
package weapons.common

import cl.uchile.dcc.characters.commoncharacters.{Knight,Archer}
import cl.uchile.dcc.characters.magiccharacters.{WhiteMage}
import weapons.Weapon

/**
 * A common class weapon that can be wielded by Knights, Archers and White Mages
 * @param name name of the weapon
 * @param attack attack points
 * @param weight weight of the weapon
 */
class Bow(val name: String, val attack: Double, val weight: Double) extends Weapon {

}
