package acciones
import unidades.Personajes
import utilizables.utilizable

class EquiparArma(nombre:String,PosibleObjects : List[utilizable]) extends AccionConUtilizables(nombre, PosibleObjects):
  override def ejecutadaPorPersonaje(fuente: Personajes, objetivo: Target): Boolean =
    PosibleObjects.contains(objetivo) && objetivo.equiparseEn(fuente)