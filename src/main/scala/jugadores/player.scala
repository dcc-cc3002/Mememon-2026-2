package jugadores
import scala.collection.mutable
import unidades.{Unidad}

trait player:
  val ListaUnidades = mutable.ListBuffer[Unidad]()
  var VictoriaOrDefeat: Boolean = false
