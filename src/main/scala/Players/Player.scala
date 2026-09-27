package cl.uchile.dcc
package Players

import Units.Units

import scala.collection.mutable.ListBuffer

class Player(val Name : String):
  private var UnitsList = ListBuffer[Units]()
  private var Defeated: Boolean = false