package com.avertia.mus

/**
 * Clase que contiene la jugada concreta. De momento sólo contendrá las cartas, que siempre
 * deberían ser cuatro
 * @param cartas Seq[[Carta]] con las 4 cartas para jugar
 */
class Jugada(val cartas: Seq[Carta]) {

  /**
   * Metodo que a de realizar mus. Se deberá de controlar los descartes, repartir nuevas cartas y
   * controlar el mazo. Este método devolverá una nueva jugada con las cartas mantenidas, y las
   * nuevas cartas despues del descarte
   * Pista: Ver como funciona el metodo ZIP en las colecciones
   * @param descarte Seq[[Int]] con valores de 1 a 4 que se corresponderá con el orden de las
   *                 cartas mostradas
   * @return La nueva [[Jugada]]
   */
  def mus(descarte: Seq[Int]): Jugada = ???


  /**
   * Vuelca en una variable las cartas de la jugada. Cada carta tiene que expresarse de la
   * siguiente manera:
   * [Indice] "ValorCarta" de "PaloCarta"
   * Pista: El ZIP es tu amigo
   * @return [[String]] con todas la cartas
   */
  override def toString: String = {

    val cartasString = ???

    s"""Cartas del jugador:
       |********************
       |$cartasString
       |""".stripMargin
  }
}
