package acciones

import unidades.{Enemigos, MagoBlanco, MagoNegro, Personajes, PersonajesMagico}
import utilizables.utilizable

trait accion:
  val nombre: String

  def ejecutadaPorPersonaje(fuente: Personajes, objetivo: Target): Boolean

  def ejecutadaPorMagoNegro(fuente: MagoNegro, objetivo: Target): Boolean

  def ejecutadaPorMagoBlanco(fuente: MagoBlanco, objetivo: Target): Boolean

  def ejecutadaPorEnemigo(fuente: Enemigos, objetivo: Target): Boolean


abstract class Hechizo(override val nombre: String, var ManaPoints: Int)  extends AbstractAccion(nombre):
  protected def lanzar(mago: PersonajesMagico, objetivo: Target): Boolean =
    if mago.ManaPoints >= ManaPoints && aplicarEfecto(mago.danioMagico, objetivo) then
      mago.pagarHechizo(ManaPoints)
      true
    else false

  protected def aplicarEfecto(danioMagico: Int, objetivo: Target): Boolean

abstract class MagiaOscura(nombre: String, ManaPoints:Int) extends Hechizo(nombre, ManaPoints):
  override def ejecutadaPorMagoNegro(fuente: MagoNegro, objetivo: Target): Boolean =
    lanzar(fuente, objetivo)

abstract class MagiaDeLuz(nombre:String, ManaPoints:Int) extends Hechizo(nombre, ManaPoints):
  override def ejecutadaPorMagoBlanco(fuente: MagoBlanco, objetivo: Target): Boolean =
    lanzar(fuente, objetivo)


abstract class AccionConUtilizables(override val nombre: String,val PosibleObjects : List[utilizable]) extends AbstractAccion(nombre)




