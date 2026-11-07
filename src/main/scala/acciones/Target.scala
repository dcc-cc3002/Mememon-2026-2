package acciones

import unidades.{Personajes, Unidad}


trait Target:

  def recibirAtaque(danio: Int): Boolean


  def recibirMovimiento(unidad: Unidad): Boolean


  def equiparseEn(personaje: Personajes): Boolean


  def consumirsePor(personaje: Personajes): Boolean


  def recibirTrueno(danioMagico: Int): Boolean


  def recibirMeteorito(danioMagico: Int): Boolean


  def recibirCuracion(danioMagico: Int): Boolean


  def recibirPurificacion(danioMagico: Int): Boolean
