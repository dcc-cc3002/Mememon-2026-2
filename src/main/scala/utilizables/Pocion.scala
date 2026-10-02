package utilizables

trait Pocion extends utilizable:
  val nombre : String

abstract class PocionComun(override val nombre: String) extends Pocion



abstract class PocionMagica(override val nombre: String) extends Pocion


  