package cl.uchile.dcc
package model.units

import model.units.MagicCharacter

class BlackMagician(
                   name: String,
                   healthPoints: Int,
                   defensePoints: Int,
                   weight: Int,
                   manaPoints: Int
                   ) extends MagicCharacter(name, healthPoints, defensePoints, weight, manaPoints)