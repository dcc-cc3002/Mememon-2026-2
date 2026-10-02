package utilizables
import unidades.Personajes


abstract class Arma(override val nombre: String,var AttackPoints: Int, var weight: Double,var owner: Personajes) extends utilizable
