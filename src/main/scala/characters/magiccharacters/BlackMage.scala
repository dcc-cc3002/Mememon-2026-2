package cl.uchile.dcc
package characters.magiccharacters

import cl.uchile.dcc.characters.MagicCharacter

/**
 * Represents the character class of Black Mage, which extends the Character trait
 * @param name name of the character
 * @param maxHp maximum health points of the character
 * @param hp current health points of the character
 * @param defense how much can they resist an attack
 * @param weight the heavier they are, the longer they take to execute an action
 * @param maxMana maximum mana points of the character
 * @param mana current mana points of the character
 */
class BlackMage(val name: String, val maxHp: Double, var hp: Double, var defense: Double, val weight: Double, val maxMana: Double, var mana: Double) extends MagicCharacter{

}
