package cl.uchile.dcc
package Personajes
import cl.uchile.dcc.Armamento.Arma
import cl.uchile.dcc.Pociones.Pocion
import scala.collection.mutable.ListBuffer

abstract class Personaje(val nombre: String,
                         val puntosDeVida: Int,
                         val defensa: Int,
                         val peso: Int,
                         var arma: ListBuffer[Arma] = ListBuffer[Arma](),
                         var inventario: ListBuffer[Pocion] = ListBuffer[Pocion]()
                        )

abstract class PersonajeMagico( nombre: String,
                                puntosDeVida: Int,
                                defensa: Int,
                                peso: Int,
                                puntosMana: Int,
                                arma: ListBuffer[Arma] = ListBuffer[Arma](),
                                inventario: ListBuffer[Pocion] = ListBuffer[Pocion]()
                              ) extends Personaje(nombre, puntosDeVida, defensa, peso, arma, inventario)


class Caballero( nombre: String,
                 puntosDeVida: Int,
                 defensa: Int,
                 peso: Int,
                 arma: ListBuffer[Arma] = ListBuffer[Arma](),
                 inventario: ListBuffer[Pocion] = ListBuffer[Pocion]()
               ) extends Personaje(nombre, puntosDeVida, defensa, peso, arma, inventario)

class Arquero( nombre: String,
               puntosDeVida: Int,
               defensa: Int,
               peso: Int,
               arma: ListBuffer[Arma] = ListBuffer[Arma](),
               inventario: ListBuffer[Pocion] = ListBuffer[Pocion]()
             ) extends Personaje(nombre, puntosDeVida, defensa, peso, arma, inventario)

class Ladron( nombre: String,
              puntosDeVida: Int,
              defensa: Int,
              peso: Int,
              arma: ListBuffer[Arma] = ListBuffer[Arma](),
              inventario: ListBuffer[Pocion] = ListBuffer[Pocion]()
            ) extends Personaje(nombre, puntosDeVida, defensa, peso, arma, inventario)

class MagoNegro( nombre: String,
                 puntosDeVida: Int,
                 defensa: Int,
                 peso: Int,
                 puntosMana: Int,
                 arma: ListBuffer[Arma] = ListBuffer[Arma](),
                 inventario: ListBuffer[Pocion] = ListBuffer[Pocion]()
               ) extends PersonajeMagico(nombre, puntosDeVida, defensa, peso, puntosMana, arma)

class MagoBlanco( nombre: String,
                  puntosDeVida: Int,
                  defensa: Int,
                  peso: Int,
                  puntosMana: Int,
                  arma: ListBuffer[Arma] = ListBuffer[Arma](),
                  inventario: ListBuffer[Pocion] = ListBuffer[Pocion]()
                ) extends PersonajeMagico(nombre, puntosDeVida, defensa, peso, puntosMana, arma)

