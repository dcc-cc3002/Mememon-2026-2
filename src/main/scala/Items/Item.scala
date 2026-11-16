package cl.uchile.dcc
package Items

import Exceptions.invalidInputException
import Source_target.{source, target}
import Units.{abstractUnits, BlackWizard, enemy, WhiteWizard}

trait Item extends target

//almost every item cannot do or receive an action, but the exceptions are treated in each class that implements some action
abstract class AbstractItem extends Item {
  override def isAlive: Boolean = true //done this way to be capable of bypass the "alive" requisite
  override def receiveAttackFromCharacter(source: Units.character): Unit = throw invalidInputException("An item cannot be attacked")
  override def receiveAttackFromEnemy(source: enemy): Unit = throw invalidInputException("An item cannot be attacked")
  override def receiveHeal(source: WhiteWizard): Unit = throw invalidInputException("An item cannot be healed")
  override def receiveMeteorite(source: source): Unit = throw invalidInputException("An item cannot receive damage")
  override def receivePurification(source: WhiteWizard): Unit = throw invalidInputException("An item cannot receive damage")
  override def receiveThunder(source: BlackWizard): Unit = throw invalidInputException("An item cannot receive damage")
  override def setNewPosition(source: abstractUnits): Unit = throw invalidInputException("An item cannot be a new position")
}
  
