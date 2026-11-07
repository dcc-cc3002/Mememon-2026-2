package unidades
import utilizables.Arma

//esto es una ramifiacion mas profunda por eso ocupamos



//abstract class Personaje (val nombre: String, var HpPoints: Int, var DefensePoints: Int, var weight: Int) extends unidad:

  // aqui deber ir slot de arma, unica supongo, e inventario(lista de cosas supongo, de utilizables)
// var Slot_Arma: Option[armamento] = None
//  var inventarioUtilizables: utilizables = mutable.ListBuffer[armamento]()


class Caballero(nombre: String,HpPoints: Int,DefensePoints: Int,weight: Int) extends Personajes(nombre, HpPoints, DefensePoints, weight):
  override def puedeEquipar(arma: Arma): Boolean = arma.equipablePorCaballero