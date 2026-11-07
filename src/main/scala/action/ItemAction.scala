package cl.uchile.dcc
package action

import cl.uchile.dcc.item.Item

/**trait for actions that use items from a certain allowed list*/

trait ItemAction extends Action{
  /** list of usable items */
  val items: List[Item]
}
