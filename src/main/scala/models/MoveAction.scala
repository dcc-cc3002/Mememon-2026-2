package cl.uchile.dcc
package models

class MoveAction(val targetPanel: Panel) extends Action {
  override def id: String = "move"

  override def executeByCharacter(source: AbsCharacter, target: Target): Boolean = {
    require(source.hp > 0, "Una unidad debe tener HP positivo para realizar una acción.")

    require(source.currentPanel.isDefined, "El personaje no está ubicado en ningún panel.")

    require(source.currentPanel.get.isAdjacentTo(targetPanel), "El panel al que se desplaza debe ser uno de los paneles aledaños a él.")

    source.currentPanel = Some(targetPanel)
    true
  }

  override def executeByEnemy(source: Enemy, target: Target): Boolean = {
    require(source.hp > 0, "Una unidad debe tener HP positivo para realizar una acción.")
    require(source.currentPanel.isDefined, "El enemigo no está ubicado en ningún panel.")
    require(source.currentPanel.get.isAdjacentTo(targetPanel), "El panel al que se desplaza debe ser uno de los paneles aledaños a él.")

    source.currentPanel = Some(targetPanel)
    true
  }
}