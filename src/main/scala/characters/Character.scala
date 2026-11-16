package cl.uchile.dcc
package characters

import cl.uchile.dcc.unit.GameUnit
import cl.uchile.dcc.weapons.Weapon
import cl.uchile.dcc.item.Item
import scala.collection.mutable.ArrayBuffer

/**
 * Here I will define the common characteristics of both
 * common characters and magic characters, so the 5 classes
 * can extend.
 */

trait Character extends GameUnit{
  /** every character has an inventory of items, which can be defined as a list */
  private val inventory: ArrayBuffer[Item] = ArrayBuffer()
  /** all characters can use a weapon depending on their type. Initially will be defined as None since they can equip one during the game*/
  private var weapon: Option[Weapon] = None
  /** consult inventory*/
  def getInventory: List[Item] = inventory.toList
  /** consult equipped weapon */
  def equippedWeapon: Option[Weapon] = weapon
  /** character can equip a weapon */
  def equipWeapon(newWeapon: Weapon): Unit = {
    weapon = Some(newWeapon)
  }

  /** action bar depends on a character's weight and equipped weapon */
  def actionBarMax: Double = {
    val weaponWeight = equippedWeapon.map(_.weight).getOrElse(0.0)
    weight+ 0.5 * weaponWeight

  }
}