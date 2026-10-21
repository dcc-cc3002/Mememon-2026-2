package cl.uchile.dcc
package cl.uchile.dcc.characters.magiccharacters

/**
 * Represents one of the magical characters, which cannot use magic. In this case, a White Mage
 * @param name name of the character
 * @param hp health points of the character
 * @param defense how much can they resist an attack
 * @param weight the heavier they are, the longer they take to execute an action
 * @param mana the mana they have
 * */
class whiteMage(val name: String, var hp: Int, var defense: Int, val weight: Int, var mana: Int){

}
