package com.avertia.mus

object Jugar {

  /**
   * Controlamos el juego con este main
   * @param args
   */
  def main(args: Array[String]): Unit = {

    //Repartimos la carta la primera vez
    var jugada = new Jugada(Baraja.repartirCartas(4))
    println(jugada.toString)

    //Entramos en un bucle hasta que decidimos dejar de darnos mus
    var terminar = false
    while (!terminar) {
      println("Quieres Mus? (S/N) >")
      val mus = scala.io.StdIn.readLine().trim.toUpperCase()

      mus match {
        case "S" =>
          println("Indica los descartes separado por 'comas'")
          val descartesInput = scala.io.StdIn.readLine()

          //Controlamos las interaccion con el usuario
          try {
            val descartes = descartesInput.trim.split(',') map (_.toInt)
            if (descartes.size > 4 || descartes.forall(x=> x>4))
              throw new Exception("Maaaaal")
            jugada = jugada.mus(descartes)
            println(jugada.toString)
          }catch{
            case e:Exception => println("Descartes mal introducidos...")
          }

        case "N" => terminar = true
        case _ => println("No es tan dificil...")
      }
    }

    //Imprimimos las cartas que quedaban en el mazo. Meramente informativo y de comprobación.
    println(Baraja.toString)
  }
}
