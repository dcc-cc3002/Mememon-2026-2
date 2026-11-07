package unidades

import acciones.{AbstractTarget, accion}
import mapajuego.Panel


abstract class AbstractUnidad(override val nombre: String, var HpPoints: Int,
                              var DefensePoints: Int, var weight: Double)
  extends AbstractTarget, Unidad:

  /** Puntos de vida máximos: la vida con la que se creó la unidad. */
  val maxHpPoints: Int = HpPoints

  var panelActual: Option[Panel] = None

  override def buscarAccion(nombreAccion: String): Option[accion] =
    var encontrada: Option[accion] = None
    for accion <- acciones do
      if encontrada.isEmpty && accion.nombre == nombreAccion then
        encontrada = Some(accion)
    encontrada


  override def recibirAtaque(danio: Int): Boolean =
    perderVida(danio - DefensePoints)
    true

  override def recibirTrueno(danioMagico: Int): Boolean =
    recibirDanioMagico(danioMagico)
    true

  override def recibirDanioMagico(danio: Int): Unit =
    perderVida(danio)


  def curar(cantidad: Int): Unit =
    HpPoints = HpPoints + cantidad
    if HpPoints > maxHpPoints then HpPoints = maxHpPoints

  protected def perderVida(cantidad: Int): Unit =
    if cantidad > 0 then
      HpPoints = HpPoints - cantidad
      if HpPoints < 0 then HpPoints = 0
