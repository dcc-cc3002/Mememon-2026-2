package cl.uchile.dcc
package Actions

abstract class MagicAction(val Name : String) extends Action

class Meteorite(Name:String) extends MagicAction(Name)
class Thunder(Name:String) extends MagicAction(Name)
class Heal(Name:String) extends MagicAction(Name)
class Purification(Name:String) extends MagicAction(Name)