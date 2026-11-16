package cl.uchile.dcc
package Exceptions

case class invalidWeaponToSpellException(message:String) extends Exception(message)