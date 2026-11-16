package cl.uchile.dcc
package weapons.magical

import cl.uchile.dcc.characters.commoncharacters.{Archer}
import cl.uchile.dcc.characters.magiccharacters.{BlackMage, WhiteMage}
import weapons.MagicWeapon


/**
 * A magical class weapon that can be wielded by Black and White Mages
 *
 * @param name name of the weapon
 * @param attack attack points of the weapon
 * @param weight weight of the weapon
 * @param magicAttack points of magic attack used for spells
 * */

class Wand(val name: String, val attack: Double, val weight: Double, val magicAttack: Double) extends MagicWeapon {

}
