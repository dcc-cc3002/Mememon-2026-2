package unidades

abstract class PersonajesMagico(nombre: String,HpPoints: Int,DefensePoints: Int,weight: Double,var ManaPoints: Double) extends  Personajes(nombre, HpPoints, DefensePoints, weight):
  val maxManaPoints: Double = ManaPoints
  private var fuerzaMagicaActiva: Boolean = false

  override def equals(obj: Any): Boolean =
    super.equals(obj) &&
      ManaPoints == obj.asInstanceOf[PersonajesMagico].ManaPoints

  def tieneFuerzaMagica: Boolean = fuerzaMagicaActiva

  def danioMagico: Int =
    val base = if SlotArma.isDefined then SlotArma.get.ataqueMagico else 0
    if fuerzaMagicaActiva then base * 3 / 2 else base

  def pagarHechizo(costo: Int): Unit =
    ManaPoints = ManaPoints - costo
    fuerzaMagicaActiva = false

  override def recibirPocionMana(): Boolean =
    ManaPoints = ManaPoints + maxManaPoints * 0.3
    if ManaPoints > maxManaPoints then ManaPoints = maxManaPoints
    true

  override def recibirFuerzaMagica(): Boolean =
    fuerzaMagicaActiva = true
    true