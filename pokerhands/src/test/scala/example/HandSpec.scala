package example
import org.scalatest._

class HandSpec extends FlatSpec with Matchers{
  it should "return the same suit" in {
    val black = Hand(List("2H", "3H", "4H", "5H", "6H"))
    black.isSameSuit shouldEqual (true)
  }

  it should "not return the same suit" in {
    val white = Hand(List("2C", "3H", "4S", "8C", "AH"))
    white.isSameSuit shouldEqual (false)
  }

  it should "be conservative" in {
    val black = Hand(List("2H", "3H", "4H", "5H", "6H"))
    black.isSequential shouldEqual (true)
  }

  it should "not be conservative" in {
    val black = Hand(List("2D", "3H", "5C", "9S", "KH"))
    black.isSequential shouldEqual (false)
  }

}