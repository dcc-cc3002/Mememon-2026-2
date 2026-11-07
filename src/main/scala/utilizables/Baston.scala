package utilizables
import unidades.Personajes

class Baston(nombre: String,AttackPoints: Int,weight: Double,owner: Personajes, AttackPointsM: Int) extends ArmaMagic(nombre, AttackPoints, weight, owner, AttackPointsM):
  override def equipablePorMagoNegro: Boolean = true
  override def equipablePorMagoBlanco: Boolean = true


