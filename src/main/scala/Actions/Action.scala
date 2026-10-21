package cl.uchile.dcc
package Actions

import Sourse_target.{ Source, Target}


trait Action(Name: String):
  def Act(source:Source,target:Target):Unit



