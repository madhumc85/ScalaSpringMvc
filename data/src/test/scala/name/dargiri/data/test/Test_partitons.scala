package name.dargiri.data.test

/**
  * Created by chamadhu on 5/15/2016.
  */
object Test_Partitions {
  def main(args: Array[String]) {
    var numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    def isEven(x: Int): Boolean = x % 2 == 0
    var (evns, ods) = {
      numbers partition isEven
    }
    println(evns)
    println(ods)


  }
}