package cl.uchile.dcc
package Mapa

import scala.collection.mutable.ListBuffer
class Panel(val x: Int, val y: Int, val MaxX: Int, val MaxY: Int):
  var UnitsList = ListBuffer[Character]()
  val Neighbourhood : ListBuffer[(Int,Int)] = {
    val PanelList = ListBuffer[(Int,Int)]()
    if x>=2 then PanelList += ((x-1,y))
    if x<=MaxX-1 then PanelList += ((x+1,y))
    if y>=2 then PanelList += ((x,y-1))
    if y<=MaxY-1 then PanelList += ((x,y+1))
    PanelList
  }