package cl.uchile.dcc
package model.units

/** Base class that stores the properties shared by all units.
 *
 * @param name The name of the unit.
 * @param health The health points of the unit.
 * @param defense The defense points of the unit.
 * @param weight The weight of the unit.
 */
abstract class AbstractUnit(val name: String, val health: Int, val defense: Int, val weight: Int) extends UnitsCommon

