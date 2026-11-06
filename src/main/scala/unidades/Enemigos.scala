package unidades

//capaz despues al igual que con personajes se va a tener que hacer una diferencia entre enemigo normal y magico
class Enemigos(override val nombre: String,var HpPoints: Int,var DefensePoints: Int,var weight: Double,var AttackPoints: Int) extends Unidad:
  override def BarraAccion: Double = weight
  override def equals(obj: Any): Boolean =
    if getClass == obj.getClass then
      val other = obj.asInstanceOf[Enemigos]
      nombre == other.nombre &&
        HpPoints == other.HpPoints &&
        DefensePoints == other.DefensePoints &&
        weight == other.weight &&
        AttackPoints == other.AttackPoints
    else false
  