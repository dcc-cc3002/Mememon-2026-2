package cl.uchile.dcc
package Source_target

import Units.{abstractUnits, BlackWizard, character, enemy, WhiteWizard}

//target is the class that receives an action from a source
trait target:

  def Name: String
  def isAlive : Boolean
  def receiveAttackFromCharacter(source : character) : Unit
  def receiveAttackFromEnemy(source: enemy):Unit


  def receivePurification(source:WhiteWizard):Unit
  def receiveHeal(source:WhiteWizard):Unit

  def receiveMeteorite(source:source):Unit
  def receiveThunder(source: BlackWizard): Unit
  def beSet(source: character): Unit
  def setNewPosition(source:abstractUnits): Unit
  def beConsumed(source:character):Unit