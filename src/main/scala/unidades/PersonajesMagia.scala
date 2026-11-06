package unidades

abstract class PersonajesMagico(nombre: String,HpPoints: Int,DefensePoints: Int,weight: Double,var ManaPoints: Double) extends  Personajes(nombre, HpPoints, DefensePoints, weight):
  override def equals(obj: Any): Boolean =
    super.equals(obj) &&
      ManaPoints == obj.asInstanceOf[PersonajesMagico].ManaPoints