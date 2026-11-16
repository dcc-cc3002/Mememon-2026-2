package cl.uchile.dcc
package action

import scala.collection.mutable.ArrayBuffer
import cl.uchile.dcc.weapons.{Weapon, MagicWeapon}
import cl.uchile.dcc.weapons.common.{Bow,Sword,Dagger }
import cl.uchile.dcc.weapons.magical.{Staff,Wand}
import cl.uchile.dcc.characters.{Character, MagicCharacter}

/** Action of equipping a weapon 
 * @param name name of the action
 * */
class EquipWeapon extends ItemAction {
  val name: String = "Equip weapon"
  /** list of possible items to use*/
  val items: List[Weapon] = List.empty[Weapon]
}
