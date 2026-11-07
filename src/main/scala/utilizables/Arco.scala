package utilizables

import unidades.Personajes

class Arco(nombre: String,AttackPoints: Int,weight: Int,owner: Personajes) extends Arma(nombre, AttackPoints, weight, owner):
  override def equipablePorCaballero: Boolean = true
  override def equipablePorArquero: Boolean = true
  override def equipablePorMagoBlanco: Boolean = true
  