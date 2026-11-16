package cl.uchile.dcc
package Actions

import Source_target.{source, target}

//attack is an action that every unit can do to another (except if a character doesn't have a weapon)
class attack(val Name:String="Attack") extends action(Name):
  def Act(source:source, target:target):Unit = source.doAttack(target)

//move moves an unit to another panel
class move(val Name:String="Move") extends action(Name):
  def Act(source:source, target:target):Unit =
    source.beMovedTo(target)
