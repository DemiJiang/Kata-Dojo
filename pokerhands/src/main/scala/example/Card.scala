package example

import scala.collection.Map

class Card(card:String) {

  def face: String = {
    card.slice(0, 1)
  }

  def suit: String = {
    card.slice(1, 2)
  }

  def rank: Int = {
    Card.keyForRank(face)
  }

}

  object Card{
    def apply(cs:String) : Card = new Card(cs)

    def keyForRank(key: String): Int = {
      rank.find(v => v._1 == key).get._2
    }

    val rank = Map(
      "2" -> 2,
      "3" -> 3,
      "4" -> 4,
      "5" -> 5,
      "6" -> 6,
      "7" -> 7,
      "8" -> 8,
      "9" -> 9,
      "T" -> 10,
      "J" -> 11,
      "Q" -> 12,
      "K" -> 13,
      "A" -> 14
              )

    }




