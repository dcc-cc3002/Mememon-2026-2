package cl.uchile.dcc
package Enemigo
import cl.uchile.dcc.ProgramadorTurnos.Unidad

class Enemigo(val nombre: String,
              val PuntosDeVida: Int,
              val ataque: Int,
              val defensa: Int,
              val peso: Int
             ) extends Unidad:
              def barraMaxima: Int =
                peso


