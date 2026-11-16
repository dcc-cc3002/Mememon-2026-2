package cl.uchile.dcc
package Exceptions

case class invalidInputException(message:String) extends Exception(message)