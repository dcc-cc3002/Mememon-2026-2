package utilizables
import unidades.Personajes
class FuerzaMagica(nombre:String) extends PocionMagica(nombre):
  override protected def aplicarA(personaje: Personajes): Boolean =
    personaje.recibirFuerzaMagica()
