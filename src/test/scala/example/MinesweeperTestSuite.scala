package example

import org.scalatest._
import Minesweeper._

class MinesweeperTestSuite extends FlatSpec with Matchers{
  it should "return an empty 2D list" in {
    val input = List(List())

    val expected = List(List())

    Sweeper(input) shouldEqual expected
  }

  it should "return 2X2 expected list" in {
    val input = List(
                  List('*','.'),
                  List('.','.'))
    val expected =
                List(
                  List('*','1'),
                  List('1','1'))

    Sweeper(input) shouldEqual expected
  }

  it should "return 4X4 expected list" in {
    val input = List(
                 List('*','.','.','.'),
                 List('.','.','.','.'),
                 List('.','*','.','.'),
                 List('.','.','.','.'))

    val expected = List(
                      List('*','1','0','0'),
                      List('2','2','1','0'),
                      List('1','*','1','0'),
                      List('1','1','1','0'))

    Sweeper(input) shouldEqual expected
  }

  it should "return 3X5 expected list" in {
    val input = List(
      List('*','*','.','.','.'),
      List('.','.','.','.','.'),
      List('.','*','.','.','.'),
      )

    val expected = List(
      List('*','*','1','0','0'),
      List('3','3','2','0','0'),
      List('1','*','1','0','0'),
      )

    Sweeper(input) shouldEqual expected
  }
}
