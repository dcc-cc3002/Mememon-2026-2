package cl.uchile.dcc
package Pociones

abstract class Pocion(val nombre: String
                     )
class PocionCuracion(nombre: String
                    ) extends Pocion(nombre)

class PocionFortaleza(nombre: String
                    ) extends Pocion(nombre)

class PocionMana(nombre: String
                    ) extends Pocion(nombre)

class PocionFuerzaMagica(nombre: String
                    ) extends Pocion(nombre)

