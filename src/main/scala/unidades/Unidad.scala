package  unidades
//T esta tiene el mismo-ish nombre que el nombre de carpeta, por lo que de aqui sale
//T todo el resto,
//T dealmente como de aqui va a salir todo lo demas, es muy,general para ser ocupado  entonces tiene que ser trait
//mas adelante, en otros files dentro de esta misma carpeta, cuando nos empecemos a ir mas por las ramas,
//y bajesmos de clases abstractas, podemos empezar a implementar clases


//notar que no es necesario que argumento de package igual a el del file pero es convencion


//notar que unidad igual a nombre de file, pero esto es solo convencion
trait Unidad:
  val nombre:String
  var HpPoints: Int
  var DefensePoints: Int
  var weight:Double

