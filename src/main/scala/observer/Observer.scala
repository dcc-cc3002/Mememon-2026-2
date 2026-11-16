package cl.uchile.dcc
package observer

/**
 * Observer will react based on the updates of the different units
 */

trait Observer {
  /** defines the received update of a subject */
  def update(): Unit

}
