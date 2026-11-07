package utilizables
import unidades.Personajes
class Fortaleza(nombre:String) extends PocionComun(nombre):
  override protected def aplicarA(personaje: Personajes): Boolean =
    personaje.aumentarDefensa(personaje.DefensePoints * 15 / 100)
    true