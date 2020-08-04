package scripts

import scala.io.Source

class Helper {

   def loadFile[A](location: String, f: Array[String] => A): List[A] = {
    val bufferedSource = Source.fromResource(location)
    val result = bufferedSource.getLines().drop(1).toList.map(line => {
      val values = line.split(",").map(_.trim)
      f(values)
    })
    println(s"${location} contains ${result.length} items")
    bufferedSource.close()
    result
  }

  def getValue(values: Array[String], i: Int): String = if(values.length > i) {values(i)} else {""}

}
