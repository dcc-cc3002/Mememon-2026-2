package acciones

import unidades.{Enemigos, Personajes}


class Moverse(override val nombre: String) extends AbstractAccion(nombre):
  override def ejecutadaPorPersonaje(fuente: Personajes, objetivo: Target): Boolean =
    objetivo.recibirMovimiento(fuente)

  override def ejecutadaPorEnemigo(fuente: Enemigos, objetivo: Target): Boolean =
    objetivo.recibirMovimiento(fuente)