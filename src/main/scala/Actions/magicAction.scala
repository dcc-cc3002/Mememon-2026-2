package cl.uchile.dcc
package Actions

import Source_target.{source, target}

abstract class WhiteWizardAction(Name: String) extends action(Name)
abstract class BlackWizardAction(Name: String) extends action(Name)

//meteorite is a spell that do damage to an area of panels
class meteorite(val Name:String="Meteorite") extends BlackWizardAction(Name):
  //Double dispatch function, give each source and target the responsibility of the actions that they can use
  def Act(source:source, target:target):Unit =
    source.doMeteorite(target)

//thunder is a spell that does damage to a unit
class thunder(val Name:String="Thunder") extends BlackWizardAction(Name):
  //Double dispatch function, give each source and target the responsibility of the actions that they can use
  def Act(source: source, target: target): Unit =
    source.doThunder(target)

//heal is a spell that do heal a character 
class heal(val Name:String="Heal") extends WhiteWizardAction(Name):
  //Double dispatch function, give each source and target the responsibility of the actions that they can use
  def Act(source: source, target: target): Unit =
    source.doHeal(target)

//purification is a spell that do damage to an enemy
class purification(val Name:String="Purification") extends WhiteWizardAction(Name):
  //Double dispatch function, give each source and target the responsibility of the actions that they can use
  def Act(source: source, target: target): Unit =
    source.doPurification(target)
