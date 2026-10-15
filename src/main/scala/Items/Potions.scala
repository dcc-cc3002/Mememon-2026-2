package cl.uchile.dcc
package Items

import Sourse_target.Target

abstract class Potion(val Name:String) extends Item

class HealingPotion(Name:String) extends Potion(Name)
class StrengthPotion(Name:String) extends Potion(Name)
class ManaPotion(Name:String) extends Potion(Name)
class MagicStrengthPotion(Name:String) extends Potion(Name)
