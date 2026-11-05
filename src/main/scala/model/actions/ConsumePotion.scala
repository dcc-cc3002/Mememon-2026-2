package cl.uchile.dcc
package model.actions

import model.usable.usableCommon

class ConsumePotion(val name: String, val objects: List[usableCommon]) extends ActionWithUsable
