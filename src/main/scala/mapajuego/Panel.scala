package mapajuego

import scala.collection.mutable

import unidades.Unidad

// var ListUnitsPanel: mutable.ListBuffer[Unidad] = mutable.ListBuffer[]()



class Panel(var x: Int, var y: Int):
  val UnitsInPanel: mutable.ListBuffer[Unidad] = mutable.ListBuffer()
  val NeighboringPanel : mutable.ListBuffer[Panel] = mutable.ListBuffer()
  //def PanelesAledaños(): Panel =
    //blabla
    //se me ocurre, algun tipo algoritmo, que escanee en un delta de x e y, alrededor, y evaluea, si celdas
    //dentro de (dx, dy) contienen, a otro panel, si es asi, colocarlo en una lista, y delvolver esa lista
    //si al final, la lista esta vacia, entonces, devolver la lista vacia, y
  def AddNeighbor(panel:Panel):Unit =
    NeighboringPanel +=panel

  def addUnit(unidad:Unidad): Unit =
    UnitsInPanel+=unidad
    
