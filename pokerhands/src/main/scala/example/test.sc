def convertHands(str: String)= {
  val a = str.split("  ")
  val b = a(0).split(":")
  val c = a(1).split(":")
  val blackHand = b(1)
  val whiteHand = c(1)
  println(blackHand.mkString(""))
  println(whiteHand.mkString(""))

}

convertHands("Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH")

val ranks = Map("2"->2,"3"->3,"K"->13)

def keyForRank(face:String):Int={
  ranks.find(v => v._1 == face).get._2
}

