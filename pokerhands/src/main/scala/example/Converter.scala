package example

class Converter(input: String) {
  val a = input.split("  ")
  val b = a(0).split(": ")
  val c = a(1).split(": ")

  def black: List[String] = {
    b(1).split(" ").toList
  }

  def white: List[String] = {
    c(1).split(" ").toList
  }
}

