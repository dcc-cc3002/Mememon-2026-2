package cl.uchile.dcc
package item

/** It is necessary an inventory for both potions and weapons
 * so I will define a common trait for the things that a character
 * can carry, including both mentioned before */

trait Item {
  /** name of the item */
  val name: String
}
