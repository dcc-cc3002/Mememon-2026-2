package acciones

class Trueno(nombre:String, ManaPoints: Int = 20) extends MagiaOscura(nombre, ManaPoints):
  override protected def aplicarEfecto(danioMagico: Int, objetivo: Target): Boolean =
    objetivo.recibirTrueno(danioMagico)


