package cl.uchile.dcc
package model.usable

/** Contract shared by every usable item (weapons and potions). */
trait usableCommon {
  /** Returns the name of the item. */
  def name: String
}