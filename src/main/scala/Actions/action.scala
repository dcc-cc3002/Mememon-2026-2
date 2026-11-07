package cl.uchile.dcc
package Actions

import Source_target.{ source, target}

//general action, gives an object to be referenced in doAction, so the double dispatch do the job
trait action(Name: String):
  def Act(source:source, target:target):Unit



