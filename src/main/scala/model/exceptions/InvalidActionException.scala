package cl.uchile.dcc
package model.exceptions

/** Exception thrown when an action cannot be performed because one of its restrictions is not met.
 *
 * @param message The reason why the action could not be performed.
 */
class InvalidActionException(message: String) extends Exception(message)