package acciones

class Curacion(nombre :String, ManaPoints:Int = 15) extends MagiaDeLuz(nombre, ManaPoints):
  override protected def aplicarEfecto(danioMagico: Int, objetivo: Target): Boolean =
    objetivo.recibirCuracion(danioMagico)

