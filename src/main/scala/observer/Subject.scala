package cl.uchile.dcc
package observer

/**
 * Represents an entity that can notify observers of different changes in their status
 * */

trait Subject {
  /** registers an observer */
  def registerObserver(obs: Observer): Unit
  
  /** notifies registered observers of changes*/
  def notifyObserver(): Unit

}
