package example

object Main {
  def main(args: Array[String]): Unit = {
      val x = new Converter("Black: 2H 3H 4H 5H 6H  White: 2C 3H 4S 8C AH")

      println(x.black)
      println(x.white)

      val Player1 = Hand(x.black)
      val Player2 = Hand(x.white)

  }

}
