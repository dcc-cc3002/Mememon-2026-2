package acciones

class Meteorito(nombre: String, ManaPoints:Int=50) extends MagiaOscura(nombre, ManaPoints):
  override protected def aplicarEfecto(danioMagico: Int, objetivo: Target): Boolean =
    objetivo.recibirMeteorito(danioMagico)