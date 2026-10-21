package cl.uchile.dcc
package Actions

import Sourse_target.{ Source, Target}

abstract class WhiteWizardAction(Name: String) extends Action(Name)
abstract class BlackWizardAction(Name: String) extends Action(Name)

class Meteorite(val Name:String="Meteorite") extends BlackWizardAction(Name):
  def Act(source:Source,target:Target):Unit =
    target.receiveMeteorite(source)

class Thunder(val Name:String="Thunder") extends BlackWizardAction(Name):
  def Act(source: Source, target: Target): Unit =
    target.receiveThunder(source)

class Heal(val Name:String="Heal") extends WhiteWizardAction(Name):
  def Act(source: Source, target: Target): Unit =
    target.receiveHeal(source)

class Purification(val Name:String="Purification") extends WhiteWizardAction(Name):
  def Act(source: Source, target: Target): Unit =
    target.receivePurification(source)
