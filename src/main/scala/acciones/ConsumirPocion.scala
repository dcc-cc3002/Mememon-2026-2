package acciones
import unidades.Personajes
import utilizables.utilizable

class ConsumirPocion(nombre: String, PosibleObjects : List[utilizable]) extends AccionConUtilizables(nombre, PosibleObjects):
  override def ejecutadaPorPersonaje(fuente: Personajes, objetivo: Target): Boolean =
    PosibleObjects.contains(objetivo) && objetivo.consumirsePor(fuente)