package unidades
import scala.collection.mutable
import utilizables.Arma
import acciones.{accion, Atacar, ConsumirPocion, EquiparArma, Moverse, Target}
import utilizables.utilizable

import utilizables.{Arma, utilizable}
//esto seria una clase abstracta,

abstract class Personajes(override val nombre: String,HpPoints:Int,DefensePoints: Int,weight: Double) extends AbstractUnidad(nombre, HpPoints, DefensePoints, weight):

  var SlotArma: Option[Arma] = None
  var inventario: mutable.ListBuffer[utilizable] = mutable.ListBuffer()

  override def equals(obj: Any): Boolean =
    if getClass == obj.getClass then
      val other = obj.asInstanceOf[Personajes]
      nombre == other.nombre &&
        HpPoints == other.HpPoints &&
        DefensePoints == other.DefensePoints &&
        weight == other.weight
    else false
  // aqui deber ir slot de arma, unica supongo, e inventario(lista de cosas supongo, de utilizables)


  override def BarraAccion: Double =
    if SlotArma.isDefined then
      weight + 0.5 * SlotArma.get.weight
    else
      weight

  def inventarioUtilizables: List[utilizable] = inventario.toList

  def agregarUtilizable(objeto: utilizable): Unit =
    inventario += objeto

  def quitarUtilizable(objeto: utilizable): Unit =
    inventario -= objeto

  override def acciones: List[accion] =
    List(
      new Atacar("Atacar"),
      new Moverse("Moverse"),
      new EquiparArma("Equipar arma", inventarioUtilizables),
      new ConsumirPocion("Consumir pocion", inventarioUtilizables)
    )

  override def doAction(accion: accion, objetivo: Target): Boolean =
    accion.ejecutadaPorPersonaje(this, objetivo)


  def puedeEquipar(arma: Arma): Boolean

  def aumentarDefensa(cantidad: Int): Unit =
    DefensePoints = DefensePoints + cantidad


  def recibirPocionMana(): Boolean = false

  def recibirFuerzaMagica(): Boolean = false

  override def recibirCuracion(danioMagico: Int): Boolean =
    curar(maxHpPoints * 20 / 100 + danioMagico / 4)
    true



