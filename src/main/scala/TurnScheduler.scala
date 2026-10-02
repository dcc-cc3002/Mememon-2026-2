package cl.uchile.dcc

import character_units.characters.Character

class TurnScheduler {
  
  var currentTurn: Option[Character] = None

  def maxActionBars: Map[Character, Float] =
    characters.map(c => c -> c.weapon.fold(c.Wgt.toFloat)(w => c.Wgt.toFloat + 0.5f * w.Wgt)).toMap

  def currentActionBars: Map[Character, Float] = characters.map(c => c -> c.actionBar).toMap

  var characters: List[Character] = List()
  
  def addCharacter(character: Character): Unit = {
    this.characters = this.characters :+ character
  }
  
  def removeCharacter(character: Character): Unit = {
    if (this.characters.contains(character)) {
      this.characters = this.characters diff List(character)
    }
  }

  def addToAll(value: Float): Unit = {
    this.characters.foreach(c => c.actionBar += value)
  }


  def completed(): List[Character] = {
    for (c <- characters if currentActionBars(c) >= maxActionBars(c)) yield c
  }

  def resetActionBars(charactersToReset: List[Character]): Unit = {
    charactersToReset.foreach(c => c.actionBar = 0.0)
  }

  def turnOrder(characters: List[Character]): List[Character] = {
    characters.sortBy(c => maxActionBars(c) - currentActionBars(c))
  }
  
}
