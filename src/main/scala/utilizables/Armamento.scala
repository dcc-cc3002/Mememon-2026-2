package utilizables
import unidades.Personajes


abstract class Arma(override val nombre: String,var AttackPoints: Int, var weight: Double,var owner: Personajes) extends utilizable:
  override def equals(obj: Any): Boolean =
    if getClass == obj.getClass then
      val other = obj.asInstanceOf[Arma]
      nombre == other.nombre &&
        AttackPoints == other.AttackPoints &&
        weight == other.weight &&
        owner == other.owner
    else false
