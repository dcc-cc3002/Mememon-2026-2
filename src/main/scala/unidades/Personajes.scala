package unidades
import scala.collection.mutable
import utilizables.Arma
import utilizables.utilizable 
//esto seria una clase abstracta,

abstract class Personajes(override val nombre: String,var HpPoints: Int,var DefensePoints: Int,var weight: Double) extends Unidad:

  // aqui deber ir slot de arma, unica supongo, e inventario(lista de cosas supongo, de utilizables)
  var Slot_Arma: Option[Arma] = None
  var inventarioUtilizables: mutable.ListBuffer[utilizable] = mutable.ListBuffer[utilizable]()

