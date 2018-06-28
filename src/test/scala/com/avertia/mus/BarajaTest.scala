package com.avertia.mus

import org.scalatest.{FlatSpec, Matchers}

class BarajaTest extends FlatSpec with Matchers {

  trait BarajaTest {
    Baraja.reiniciaMazo
  }

  "Baraja" should "tener 40 cartas antes de repartir" in new BarajaTest{

    Baraja.mazoActualizado.size shouldBe 40
  }

  it should "repartir cartas y quitarlas del mazo" in new BarajaTest{

    val jugada = Baraja.repartirCartas(3)

    Baraja.mazoActualizado.size shouldBe 37
    jugada.size shouldBe 3
  }

  it should "reiniciar mazo al terminar partida" in new BarajaTest{

    Baraja.reiniciaMazo
    Baraja.mazoActualizado.size shouldBe 40
  }

  it should "saber cuantas cartas quedan" in new BarajaTest{

    Baraja.cuantasQuedan shouldBe 40
  }

  it should "añadir a descartes las cartas de una jugada" in new BarajaTest{

    Baraja.descartar(Seq(Carta("As","Oros"),Carta("Cuatro","Copas")))
    Baraja.descartes.contains(Carta("As","Oros")) shouldBe true
    Baraja.descartes.contains(Carta("Cuatro","Copas")) shouldBe true
    Baraja.descartes.size shouldBe 2
  }

  it should "reiniciar mazo con descartes" in new BarajaTest{

    Baraja.descartes shouldBe empty

    Baraja.descartar(Seq(Carta("As","Oros"),Carta("Cuatro","Copas")))
    Baraja.volcarDescartesEnMazo

    Baraja.mazoActualizado.size shouldBe 2
  }
}
