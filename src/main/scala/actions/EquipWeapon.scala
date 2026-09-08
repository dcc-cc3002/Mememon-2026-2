package cl.uchile.dcc
package actions

import items.weapons.AbstractWeapon

class EquipWeapon extends Action {
  val name: String = "Equip Weapon"
  var possible_options: List[AbstractWeapon]
}