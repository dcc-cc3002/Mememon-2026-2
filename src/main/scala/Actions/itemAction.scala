package cl.uchile.dcc
package Actions

import Source_target.{source, target}

//ItemAction gives an identity to the actions that requieres objects like weapons or potions to be targeted
abstract class ItemAction(Name:String) extends action(Name):
  //this list called allowed gives the items that each character use a restriction, depending of the character type
  //it's a little bit unused now, because I gave the responsibility of the restrictions to each character
  var Allowed : List[String] = List.empty

//equipWeapon is the action that connects each character with their new weapon 
class equipWeapon(val Name:String ="EquipWeapon") extends ItemAction(Name):
  //Double dispatch function, give each source and target the responsibility of the actions that they can use
  def Act(source:source, target:target):Unit =
    source.setWeapon(target)
//consumePotion is the action that connects each character with the potions that they can use    
class consumePotion(val Name:String="ConsumePotion") extends ItemAction(Name):
  //Double dispatch function, give each source and target the responsibility of the actions that they can use
  def Act(source:source, target:target):Unit =
    source.consumePotion(target)