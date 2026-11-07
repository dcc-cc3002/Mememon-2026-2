package cl.uchile.dcc
package weapons.common

import cl.uchile.dcc.characters.commoncharacters.{Knight,Thief}
import cl.uchile.dcc.characters.magiccharacters.{BlackMage}
import weapons.Weapon

/**
 * A common class small weapon that can be wielded by Knights, Thieves and Black Mages
 * @param name name of the weapon
 * @param attack attack points
 * @param weight weight of the weapon
 * It can have an owner as well
 */
class Dagger(val name: String, val attack: Double, val weight: Double) extends Weapon{

}
