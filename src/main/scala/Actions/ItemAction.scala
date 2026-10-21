package cl.uchile.dcc
package Actions

import Items.{Potion, Weapon}
import Items.Item

import cl.uchile.dcc.Sourse_target.{ Source, Target}

import scala.collection.mutable.ListBuffer

abstract class ItemAction(Name:String) extends Action(Name):
  var Allowed : List[Item] = List[Item]()

class EquipWeapon(val Name:String ="EquipWeapon") extends ItemAction(Name):
  def Act(source:Source,target:Target):Unit = ???
class ConsumePotion(val Name:String="ConsumePotion") extends ItemAction(Name):
  def Act(source:Source,target:Target):Unit = ???