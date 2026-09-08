package cl.uchile.dcc
package items.weapons

import items.AbstractItem

abstract class AbstractWeapon(val name: String,
                     var Atk: Int,
                     val Wgt: Int,
                     var owner: Character,
                     val isMagic: Boolean
                    ) extends AbstractItem {


}
