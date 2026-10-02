package cl.uchile.dcc
package items.weapons

class Sword(name: String, atk: Int, wgt: Int, owner: Option[Character], isMagic: Boolean)
  extends AbstractWeapon(name, atk, wgt, owner, isMagic){

}
