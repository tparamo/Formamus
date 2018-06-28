package com.avertia.mus

import org.scalatest.{FlatSpec, Matchers}

class JugadaTest extends FlatSpec with Matchers {

  trait WithBarajaTest {
    val jugada =
      new Jugada(
        Seq(Carta("As", "Oros"), Carta("2", "Oros"), Carta("3", "Oros"), Carta("4", "Oros"))
      )
    Baraja.mazoActualizado = Baraja.mazoActualizado diff jugada.cartas
  }


  "Jugada" should "poder darse mus" in new WithBarajaTest {
    val nuevaJugada: Jugada = jugada.mus(Seq(1, 2))

    nuevaJugada.cartas.size shouldBe 4
    nuevaJugada.cartas.contains(Carta("3", "Oros"))
    nuevaJugada.cartas.contains(Carta("4", "Oros"))

    Baraja.descartes.size shouldBe 2
    Baraja.mazoActualizado.size shouldBe 34

  }

  it should "pintar las cartas de la jugada" in new WithBarajaTest {
    jugada.toString shouldBe
      "Cartas del jugador:\n********************\n[1] As de Oros\n[2] 2 de Oros\n[3] 3 de " +
        "Oros\n[4] 4 de Oros\n\n"
  }
}
