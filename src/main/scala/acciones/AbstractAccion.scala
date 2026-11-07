package acciones

import unidades.{Enemigos, MagoBlanco, MagoNegro, Personajes}


abstract class AbstractAccion(override val nombre: String) extends accion:
  override def ejecutadaPorPersonaje(fuente: Personajes, objetivo: Target): Boolean = false

  override def ejecutadaPorMagoNegro(fuente: MagoNegro, objetivo: Target): Boolean =
    ejecutadaPorPersonaje(fuente, objetivo)

  override def ejecutadaPorMagoBlanco(fuente: MagoBlanco, objetivo: Target): Boolean =
    ejecutadaPorPersonaje(fuente, objetivo)

  override def ejecutadaPorEnemigo(fuente: Enemigos, objetivo: Target): Boolean = false
