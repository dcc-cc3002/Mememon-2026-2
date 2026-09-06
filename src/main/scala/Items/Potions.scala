package cl.uchile.dcc
package Items

abstract class Potion(val Name:String)

class HealingPotion(Name:String) extends Potion(Name)
class StrengthPotion(Name:String) extends Potion(Name)
class ManaPotion(Name:String) extends Potion(Name)
class MagicStrengthPotion(Name:String) extends Potion(Name)
