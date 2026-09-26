package utilizables
import unidades.Personajes


abstract class ArmaMagic(nombre: String,AttackPoints: Int,
weight: Int,owner: Personajes,var AttackPointsM: Int) extends Arma(nombre, AttackPoints, weight, owner)
  