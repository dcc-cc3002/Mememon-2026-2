package cl.uchile.dcc
package model.actions

trait Source {
  def actionTo(target: Target): Boolean
}
