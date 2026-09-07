package cl.uchile.dcc
package Players

import Characters.Character

import scala.collection.mutable.ListBuffer
import scala.compiletime.uninitialized

class Player(val Name : String):
  var Units = ListBuffer[Character]()
  var Defeated: Boolean = false