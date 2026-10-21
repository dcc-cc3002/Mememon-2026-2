package cl.uchile.dcc
package Actions

import Sourse_target.{Source, Target}


class Attack(val Name:String="Name") extends Action(Name):
  def Act(source:Source,target:Target):Unit = source.doAttack(target)

class Move(val direction:String,val Name:String="Move") extends Action(Name):
  def Act(source:Source,target:Target):Unit =  ???
