package cl.uchile.dcc
package weapons

import cl.uchile.dcc.characters.Character
import cl.uchile.dcc.item.Item

/**
 * Here I will define the common traits that the different
 * types of weapons will have
 */
trait Weapon extends Item {
  /** Attack points */
  val attack: Double
  /** Weight of the weapon */
  val weight: Double
  /** Owner of the weapon. In an initial state, it has no owner */
  var owner: Option[Character] = None

  /** Define the characteristic to have an owner */
  def addOwner(character: Character): Unit = {
    owner = Some(character)
  }
}
