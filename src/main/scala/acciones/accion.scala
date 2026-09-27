package acciones
 
import utilizables.utilizable

trait accion:
  val nombre: String

abstract class Hechizo(override val nombre: String, var ManaPoints: Int) extends accion

abstract class MagiaOscura(nombre: String, ManaPoints:Int) extends Hechizo(nombre, ManaPoints)

abstract class MagiaDeLuz(nombre:String, ManaPoints:Int) extends Hechizo(nombre, ManaPoints)



abstract class AccionConUtilizables(override val nombre: String,val PosibleObjects : List[utilizable]) extends accion




