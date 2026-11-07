package unidades

import acciones.{accion, Atacar, Moverse, Target}
//capaz despues al igual que con personajes se va a tener que hacer una diferencia entre enemigo normal y magico
class Enemigos(override val nombre: String,HpPoints: Int, DefensePoints: Int,weight: Double,var AttackPoints: Int) extends AbstractUnidad(nombre, HpPoints, DefensePoints, weight):
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

  override def acciones: List[accion] =
    List(new Atacar("Atacar"), new Moverse("Moverse"))

  override def doAction(accion: accion, objetivo: Target): Boolean =
    accion.ejecutadaPorEnemigo(this, objetivo)
  
  override def recibirPurificacion(danioMagico: Int): Boolean =
    perderVida(HpPoints * 15 / 100 + danioMagico / 2)
    true

  