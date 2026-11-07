package acciones


trait Source:
  val nombre: String

  def acciones: List[accion]


  def buscarAccion(nombreAccion: String): Option[accion]

  /** Ejecuta una acción sobre un objetivo.
   */
  def doAction(accion: accion, objetivo: Target): Boolean
