package cl.uchile.dcc
package Map

import Sourse_target.Target

import scala.collection.mutable.ListBuffer
class Panel(val x: Int, val y: Int, val MaxX: Int, val MaxY: Int) extends Target:
  var UnitsList = ListBuffer[Character]() 
  val Neighbourhood : ListBuffer[(Int,Int)] = { //Neighborhood keeps the coordinates from the neighbors of panel, avoiding infinite recursion in the definition of panels
    val PanelList = ListBuffer[(Int,Int)]()
    if x>1 then PanelList +={(x-1,y)}
    if x<MaxX then PanelList +={(x+1,y)}
    if y>1 then PanelList +={(x,y-1)}
    if y<MaxY then PanelList +={(x,y+1)}
    PanelList
  }