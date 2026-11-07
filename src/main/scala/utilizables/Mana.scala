package utilizables

import unidades.Personajes
class Mana(nombre:String) extends PocionMagica(nombre):
  override protected def aplicarA(personaje: Personajes): Boolean =
    personaje.recibirPocionMana()
    