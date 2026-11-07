# Entrega Final 2
Para la resolución de esta entrega se tomaron en consideración los feedback entregados en la Entrega Final 1.

## Sobre decisiones de diseño
*Traits:* Definí traits para clases que utilizarían los mismos atributos, entre las cuales están:
-  GameUnit: para las unidades de juego utilizables por un jugador
-  Character: para los personajes generales del juego.
-  MagicCharacter: que extiende Character, pero agregando el atributo de portador de mana.
-  Action: para las distintas acciones posibles dentro del juego.
-  Spells: que extiende Action, agregando el costo de puntos de mana.
-  Item: para los distintos objetos utilizables en acciones y guardados en inventario
-  Weapon: extiende de Item para las distintas armas usables por personajes.
-  MagicWeapon: extiende Weapon, agregando puntos de ataque mágico.
-  Potion: extiende de Item para las distintas pociones consumibles dentro del juego
- Source: ya que las entidades que ejecutan acciones pueden ser diversas unidades u objetos del juego
- Target: similar a Source, las acciones pueden tener efecto en distintas unidades u objetos.
A partir de estos, creé las distintas clases utilizables dentro del juego.

*Clases particulares:* en este caso, dejé Enemy, TurnScheduler, Panel, Player y GameController como clases normales, ya que tendrán sus implementaciones específicas. 

*Atributos numéricos:* elegí aquellos de este estilo como Double ya que, como algunas acciones requieren porcentajes respecto de ciertas cantidades, sería más sencillo de operar (además me guié del auxiliar 7)

*Protección y privacidad de parámetros:* En Character mantuve privados el inventario y el arma equipada, y proporcioné métodos para consultarlos. De esta forma, otras clases no acceden directamente a estos atributos. El maná se modeló en MagicCharacter para reutilizar su definición entre los personajes mágicos. 

*Polimorfismo:* Definí para cada unidad de juego su propio valor de barra de acción máxima, ya que esta depende de si es personaje o enemigo, y del arma equipada. Luego en TurnScheduler, se consulta este atributo.




