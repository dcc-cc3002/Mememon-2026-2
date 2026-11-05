package cl.uchile.dcc
package model.actions

import model.usable.usableCommon

/** Action to equip a weapon.
 *
 * @param name The name of the action.
 * @param objects The usable objects the action can use.
 */
class EquipWeapon(val name: String, val objects: List[usableCommon]) extends ActionWithUsable

