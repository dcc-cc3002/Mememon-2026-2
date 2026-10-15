package cl.uchile.dcc
package Sourse_target

import Actions.Action
import Units.{Archer, BlackWizard, Enemy, Knight, MagicCharacter, Thief, WhiteWizard}

trait Target:
  def receiveKnightAction(source:Knight, action: Action) : Unit
  def receiveArcherAction(source:Archer, action: Action) : Unit
  def receiveThiefAction(source:Thief, action: Action) : Unit  
  def receiveEnemyAction(source:Enemy, action: Action) : Unit
  def receiveWhiteWizardAction(source:WhiteWizard, action: Action) : Unit
  def receiveBlackWizardAction(source:BlackWizard, action: Action) : Unit