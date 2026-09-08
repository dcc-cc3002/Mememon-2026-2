package cl.uchile.dcc
package Armamento
import cl.uchile.dcc.Personajes.Personaje

abstract class Arma (val nombre: String,
                     val PuntosDeAtaque: Int,
                     val peso: Int,
                     val owner: Personaje
                    )

abstract class ArmaMagica (nombre: String,
                            PuntosDeAtaque: Int,
                            peso: Int,
                            owner: Personaje,
                            PuntosDeAtaqueMagico: Int
                          ) extends Arma(nombre, PuntosDeAtaque, peso, owner)

class Varita( nombre: String,
              PuntosDeAtaque: Int,
              peso: Int,
              owner: Personaje,
              PuntosDeAtaqueMagico: Int
            ) extends ArmaMagica(nombre, PuntosDeAtaque, peso, owner, PuntosDeAtaqueMagico)

class Baston( nombre: String,
              PuntosDeAtaque: Int,
              peso: Int,
              owner: Personaje,
              PuntosDeAtaqueMagico: Int
            ) extends ArmaMagica(nombre, PuntosDeAtaque, peso, owner, PuntosDeAtaqueMagico)

class Espada( nombre: String,
              PuntosDeAtaque: Int,
              peso: Int,
              owner: Personaje,
              PuntosDeAtaqueMagico: Int
            ) extends Arma(nombre, PuntosDeAtaque, peso, owner)

class Daga( nombre: String,
            PuntosDeAtaque: Int,
            peso: Int,
            owner: Personaje,
            PuntosDeAtaqueMagico: Int
          ) extends Arma(nombre, PuntosDeAtaque, peso, owner)

class Arco( nombre: String,
            PuntosDeAtaque: Int,
            peso: Int,
            owner: Personaje,
            PuntosDeAtaqueMagico: Int
          ) extends Arma(nombre, PuntosDeAtaque, peso, owner)