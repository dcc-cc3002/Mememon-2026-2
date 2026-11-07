package unidades
import acciones.{accion, Curacion, Purificacion, Target}
import utilizables.Arma

class MagoBlanco(nombre: String,HpPoints:Int,DefensePoints: Int,weight:Int,ManaPoints:Int) extends PersonajesMagico(nombre, HpPoints, DefensePoints, weight, ManaPoints):
  override def acciones: List[accion] =
    super.acciones ++ List(new Curacion("Curacion"), new Purificacion("Purificacion"))

  override def doAction(accion: accion, objetivo: Target): Boolean =
    accion.ejecutadaPorMagoBlanco(this, objetivo)

  override def puedeEquipar(arma: Arma): Boolean = arma.equipablePorMagoBlanco