package utilizables
import unidades.Personajes

class Curacion(nombre:String) extends PocionComun(nombre):
  override protected def aplicarA(personaje: Personajes): Boolean =
    personaje.curar(personaje.maxHpPoints * 20 / 100)
    true