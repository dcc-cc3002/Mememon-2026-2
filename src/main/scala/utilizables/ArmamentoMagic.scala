package utilizables
import unidades.Personajes


abstract class ArmaMagic(nombre: String,AttackPoints: Int,
weight: Double,owner: Personajes,var AttackPointsM: Int) extends Arma(nombre, AttackPoints, weight, owner)
  