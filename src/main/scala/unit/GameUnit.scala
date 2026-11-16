package cl.uchile.dcc
package unit

import cl.uchile.dcc.map.Panel
import cl.uchile.dcc.observer.{Observer, Subject}
import scala.collection.mutable.ArrayBuffer

/**
 * Here I will define the common characteristics
 * that the different units of the game share
 * such as common characters, magic characters and enemies
 *
 * This will extend Subject, since its state will change during the game
 * and has to be notified to the Observer and GameController
 */

trait GameUnit extends Subject {
  /** name of the unit */
  val name: String
  /** max health of the unit*/
  val maxHp: Double
  /** the heavier, the longer they take to act*/
  val weight: Double
  /**current health of the unit*/
  var hp: Double
  /**defense points of the unit*/
  var defense: Double
  /**location in a panel of the map. Unless it is implemented by a Player, it will be None*/
  var position: Option[Panel] = None
  /** the position of the unit in the map can be defined */
  def setPanel(panel: Panel): Unit = {
    position = Some(panel)
  }
  /** every unit will have an action bar based on their weight and weapon (if it's a character)*/
  def actionBarMax: Double

  /** observers registered to this unit */
  private val observers: ArrayBuffer[Observer] = ArrayBuffer()

  /** registers an observer associated to this unit if it wasn't registered before*/
  override def registerObserver(obs: Observer): Unit = {
    if (!observers.contains(obs)) {
      observers += obs
    }
  }

  /** notifies when this unit's state changes */
  override def notifyObserver(): Unit = {
    observers.foreach(_.update())
  }

  /** case when a unit receives damage and notifies observers */
  def receiveDamage(damage: Double): Unit = {
    /** confirms that unit was alive */
    val alive = hp > 0.0
    /** current hp of the unit is affected */
    hp = math.max(0.0, hp - damage)
    /** if hp is equal to zero, notifies observer */
    if(alive &&(hp <= 0.0)){
      notifyObserver()
    }
  }
}


