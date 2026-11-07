package utilizables
import acciones.AbstractTarget
import unidades.Personajes


abstract class Arma(override val nombre: String,var AttackPoints: Int, var weight: Double,var owner: Personajes) extends AbstractTarget,utilizable:
  override def equals(obj: Any): Boolean =
    if getClass == obj.getClass then
      val other = obj.asInstanceOf[Arma]
      nombre == other.nombre &&
        AttackPoints == other.AttackPoints &&
        weight == other.weight &&
        owner == other.owner
    else false

  def ataqueMagico: Int = 0


  def equipablePorCaballero: Boolean = false

  
  def equipablePorArquero: Boolean = false

 
  def equipablePorLadron: Boolean = false

 
  def equipablePorMagoNegro: Boolean = false

 
  def equipablePorMagoBlanco: Boolean = false

 
  override def equiparseEn(personaje: Personajes): Boolean =
    if personaje.puedeEquipar(this) then
      personaje.SlotArma = Some(this)
      owner = personaje
      true
    else false

