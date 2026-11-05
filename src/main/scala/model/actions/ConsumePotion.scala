package cl.uchile.dcc
package model.actions

import model.usable.usableCommon

/** Action to consume a potion.
 *
 * @param name The name of the action.
 * @param objects The usable objects the action can use.
 */
class ConsumePotion(val name: String, val objects: List[usableCommon]) extends ActionWithUsable
