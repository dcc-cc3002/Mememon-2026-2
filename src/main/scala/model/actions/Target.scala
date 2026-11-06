package cl.uchile.dcc
package model.actions

trait Target {
  def receives(source: Source): Boolean
}
