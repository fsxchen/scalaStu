object HelloWorld {
  def echo = println("echo")
  def main(args: Array[String]): Unit = {

    for (i <- 1 to 10)
      print(i)
    println()

    for (i <- 1 to 3; j <- 1 to 3) print(i * j + " ")
    println()

    val s = for (i <- 1 to 10) yield i % 3
    println(s)
    println("===========")
    for (i <- 1 to 3; j <- 1 to 3; if i!= j) print(i * j + " ")
    println()
    import math._
    println(sqrt(2))
    println("Hello world")

    val a = new Array[String](10)
    a(0) = "hello"
    a(1) = "world"
    println(a)
    val scores = Map(
      "Ali" -> 10,
      "Bob" -> 3
    )

    println(scores("Ali"))
    val t = new Test("hello")
    val tt = Test("nihao")
    t.test
    t.say("hel")
    t.ok
//    println(t.add(1, 3))
//    echo
  }
}



//函数的
//声明和定义
// 如果函数没有参数，则不能写括号

class Test(name: String) {
  private var privateCount = 0
  println(name)
  def count = privateCount
  def count_=(v: Int):Unit = {
    privateCount = v
  }
  def test  = println("aaa")
  def say(str: String) = println(str)
  def add(a: Int, b: Int):Int = a+ b
  def ok() {println("...")}
}

object Test {
  def apply(name: String): Test = new Test(name)
}
