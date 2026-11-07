package acciones
import unidades.{Enemigos, Personajes}

class Atacar(override val nombre:String) extends AbstractAccion(nombre):
  override def ejecutadaPorPersonaje(fuente: Personajes, objetivo: Target): Boolean =
    if fuente.SlotArma.isDefined then objetivo.recibirAtaque(fuente.SlotArma.get.AttackPoints)
    else false

  override def ejecutadaPorEnemigo(fuente: Enemigos, objetivo: Target): Boolean =
    objetivo.recibirAtaque(fuente.AttackPoints)
