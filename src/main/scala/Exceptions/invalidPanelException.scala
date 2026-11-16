package cl.uchile.dcc
package Exceptions

case class invalidPanelException(message:String) extends Exception(message)