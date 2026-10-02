package unidades

//capaz despues al igual que con personajes se va a tener que hacer una diferencia entre enemigo normal y magico
class Enemigos(override val nombre: String,var HpPoints: Int,var DefensePoints: Int,var weight: Double,var AttackPoints: Int) extends Unidad:
  override def BarraAccion: Double = weight
  