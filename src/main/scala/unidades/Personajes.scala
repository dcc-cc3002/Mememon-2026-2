package unidades
import scala.collection.mutable
import utilizables.Arma
import utilizables.utilizable 
//esto seria una clase abstracta,

abstract class Personajes(override val nombre: String,var HpPoints: Int,var DefensePoints: Int,var weight: Double) extends Unidad:

  override def equals(obj: Any): Boolean =
    if getClass == obj.getClass then
      val other = obj.asInstanceOf[Personajes]
      nombre == other.nombre &&
        HpPoints == other.HpPoints &&
        DefensePoints == other.DefensePoints &&
        weight == other.weight
    else false
  // aqui deber ir slot de arma, unica supongo, e inventario(lista de cosas supongo, de utilizables)
  var SlotArma: Option[Arma] = None
  var inventarioUtilizables: mutable.ListBuffer[utilizable] = mutable.ListBuffer[utilizable]()


  override def BarraAccion: Double =
    if SlotArma.isDefined then
      weight + 0.5 * SlotArma.get.weight
    else
      weight


