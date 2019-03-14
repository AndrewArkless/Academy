//def sayName(name:String)=println(name)

trait Formatter{
  def apply(s:String):String
}

class UpperCaseFormatter extends Formatter {
  override def apply(s:String):String=s.toUpperCase()
}

class LowerCaseFormatter extends Formatter {
  override def apply(s:String):String=s.toLowerCase()
}

def sayName(name:String)(implicit f:Formatter)={
  f.apply(name)
}

implicit val formatter=new UpperCaseFormatter
//implicit val formatterlc=new LowerCaseFormatter
sayName("andrew")

//object ImplicitExample{
  trait Logger[T]{
    def log(f:T):T
  }

  class IntLogger() extends Logger[Int]{
    override def log(f:Int):Int={
      println(f)
      f
    }
  }

class stringLogger() extends Logger[String]{
  override def log(f: String): String = {
    println(f)
    f
  }

}

  implicit val logger=new IntLogger()
  implicit val stringLogger=new stringLogger()
  def double(n:Int)(implicit logger:Logger[Int])={
    logger.log{
      n*2
    }
  }

def strings(s:String)(implicit logger:Logger[String])={
  logger.log{
    s"Aaaaaaaaaaaaaaaa$s"
  }
}

  double(4)
  strings("kkk")
///////////////////////////////////////////////


implicit def doubleToString(d:Double):String={
  println("Converting double to string")
  s"$d"
}

val num:Double=2.0

val converted:String=num

object Implicits{
  implicit class NumberImplicits(n:Int){
    def double()=n*2
    def add(m:Int)=n+m
    def subtract(m:Int)=n-m

  }

  implicit class stringDec(s:String){
    def reverse(t:String)=s"$t$s"
  }
}

import Implicits._

2 double

"aaa" reverse "bbbb"


