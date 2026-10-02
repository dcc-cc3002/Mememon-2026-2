package cl.uchile.dcc
package model.weapons

abstract class MagicWeapon(
                          name: String,
                          attackPoints: Int,
                          weight: Int,
                          val magicAttackPoints: Int
                          ) extends BaseWeapon(name,attackPoints,weight)