package cl.uchile.dcc
package model

import model.units.Unit

class Player(val units: List[Unit]) {
  def isDefeated: Boolean = {
    units.forall(_.healthPoints <= 0)
  }
}