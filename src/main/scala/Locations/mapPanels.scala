package cl.uchile.dcc
package Locations

//mapPanels is the structure that's initialize the map
class mapPanels(val MaxX:Int, val MaxY:Int) {
  //this implementation of the map can change, because it can be a variable instead of a function
  def Panels:Map[(Int,Int),panel] = {
    val elements = for{x<-0 until MaxX
        y<-0 until MaxY} yield (x,y) -> new panel(x,y)
    elements.toMap
  }
  //function that initialize the map, each panel and their neighbors
  private def attachNeighbours():Unit = {
    for (((x,y),panel)<-Panels) {
      if y>0 then panel.North = Panels.get((x,y-1))
      if y < MaxY - 1 then panel.South = Panels.get((x, y + 1))
      if x > 0 then panel.West = Panels.get((x - 1, y))
      if x < MaxX - 1 then panel.East = Panels.get((x + 1, y))
    }
  }
  attachNeighbours()
  //getPanel is a getter of Panels
  def GetPanel(x:Int,y:Int) : Option[panel] = Panels.get((x,y))
}
