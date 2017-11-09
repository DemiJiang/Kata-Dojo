package example

object Minesweeper {
  def Sweeper(board: List[List[Char]]): List[List[Char]] =
    if (board.isEmpty) Nil
    else {
    board.zipWithIndex.map{
      (m) =>
        m._1.zipWithIndex.map {
          (t) => Decider(board, m._2, t._2)
        }
    }
    }

  def Decider(list: List[List[Char]], r: Int, c: Int): Char =
       if (list(r)(c) == '*') '*'
       else {
         var count = 0
         for (i <- r - 1 to r + 1) {
           if(!(i<0 || i>list.length-1))
           for (j <- c - 1 to  c + 1) {
             if((!(j<0 || j>list(i).length-1)) && list(i)(j)== '*')
             count = count +1
           }
         }
         return (count+'0').toChar
       }

  def Sweeper_1(board: List[List[Char]]): List[List[Char]] = {
    var output = List[List[Char]]()
    if (board.isEmpty) return Nil
    else
      for (row <- 0 to board.length-1) {
        var output1 = List[Char]()
        for (col <- 0 to board(row).length-1) {
           output1 = output1 :+ (Decider(board, row, col))

        }
        output = output :+ output1
      }
    output
  }

}
