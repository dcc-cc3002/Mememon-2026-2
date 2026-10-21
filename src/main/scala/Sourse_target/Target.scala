package cl.uchile.dcc
package Sourse_target

import Actions.Action
import Units.{Archer, BlackWizard, Enemy, Knight, MagicCharacter, Thief, Units, WhiteWizard}


trait Target:

  def isAlive : Boolean
  def receiveAttack(source: Units) : Unit
  def receiveThunder(source:Source) : Unit

  def receivePurification(source:Source):Unit
  def receiveHeal(source:Source):Unit

  def receiveMeteorite(source:Source):Unit
  
