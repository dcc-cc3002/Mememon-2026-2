package cl.uchile.dcc
package Exceptions

case class weaponUnequippedException(message:String) extends Exception(message)