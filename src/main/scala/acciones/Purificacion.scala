package acciones

class Purificacion(nombre:String, ManaPoints:Int=25) extends MagiaDeLuz(nombre, ManaPoints):
  override protected def aplicarEfecto(danioMagico: Int, objetivo: Target): Boolean =
    objetivo.recibirPurificacion(danioMagico)