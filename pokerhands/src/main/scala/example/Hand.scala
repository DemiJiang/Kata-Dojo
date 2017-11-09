package example;

class Hand(val cards: List[Card]) {

  //  def compareTo(that:Hand):Option[Int] = {
  //
  //  }

  //def decideWinner:String = h1

  def isSameSuit: Boolean = {
    this.cards.groupBy(_.suit).toList.length == 1
  }

  def sorted: List[Card] = {
    this.cards.sortWith(_.rank < _.rank)
  }

  def isSequential: Boolean = {
    def check(a: List[Int]): List[Int] = {
      var b = List(a.head)
      var i = 0
      for (i <- 0 to 3)
        b = b :+ b.last + 1
      b
    }

    val x = sorted.map(_.rank)
    val y = check(x)

    if (x == y)
      true
    else false
  }

}
  object Hand {
    def apply(cards: List[String]): Hand = {
      val c = cards.collect { case s: String => new Card(s) }
      new Hand(c)

    }
  }