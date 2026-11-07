package mapajuego

import scala.collection.mutable
import acciones.AbstractTarget
import unidades.Unidad

// var ListUnitsPanel: mutable.ListBuffer[Unidad] = mutable.ListBuffer[]()



class Panel(var x: Int, var y: Int) extends  AbstractTarget:
  private val unidades: mutable.ListBuffer[Unidad] = mutable.ListBuffer()
  private val vecinos: mutable.ListBuffer[Panel] = mutable.ListBuffer()

  def UnitsInPanel: List[Unidad] = unidades.toList
  def NeighboringPanel: List[Panel] = vecinos.toList

  def esAdyacente(otro: Panel): Boolean =
    math.abs(x - otro.x) + math.abs(y - otro.y) == 1
  //def PanelesAledaños(): Panel =
    //blabla
    //se me ocurre, algun tipo algoritmo, que escanee en un delta de x e y, alrededor, y evaluea, si celdas
    //dentro de (dx, dy) contienen, a otro panel, si es asi, colocarlo en una lista, y delvolver esa lista
    //si al final, la lista esta vacia, entonces, devolver la lista vacia, y
  def AddNeighbor(panel:Panel):Unit =
    if esAdyacente(panel) && !vecinos.contains(panel) then
      vecinos += panel
      panel.AddNeighbor(this)

  def addUnit(unidad:Unidad): Unit =
    if !unidades.contains(unidad) then unidades += unidad
    unidad.panelActual = Some(this)

  def quitarUnidad(unidad: Unidad): Unit =
    unidades -= unidad

  override def recibirMovimiento(unidad: Unidad): Boolean =
    if unidad.panelActual.isDefined && vecinos.contains(unidad.panelActual.get) then
      unidad.panelActual.get.quitarUnidad(unidad)
      addUnit(unidad)
      true
    else false

  override def recibirMeteorito(danioMagico: Int): Boolean =
    for unidad <- unidades.toList do
      unidad.recibirDanioMagico(danioMagico)
    true
