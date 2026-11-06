package utilizables

trait Pocion extends utilizable:
  val nombre : String


abstract class PocionBase(override val nombre: String) extends Pocion:
  override def equals(obj: Any): Boolean =
    if getClass == obj.getClass then
      val other = obj.asInstanceOf[PocionBase]
      nombre == other.nombre
    else false

//Base class only for not having duplicated code in the next two following abstract classes

abstract class PocionComun(nombre: String) extends PocionBase(nombre)


abstract class PocionMagica(nombre: String) extends PocionBase(nombre)



  