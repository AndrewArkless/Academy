import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec

import scala.util.{Failure, Success, Try}
import scala.util.control.Exception._

object NotFoundException extends Exception

def findNumber(i:Int)={

  val nums=List(1,2,3,4,5,60)
  val result=nums.find(x=>x==i)
  result match {
    case Some(p)=>p
    case _ => throw NotFoundException
  }

}

findNumber(2)
//findNumber(6)

def convertNumber(x:String)=Try(x.toInt)

convertNumber("2j") match {
  case Success(age)=>println("Success!!!")
  case Failure(exc)=>println(s"Failure ${exc.toString} ")

}

def convertInt(x:String)={
  try {
    Right(x.toInt)
  }
    catch {
      case e:Exception=>Left("Nott a number")
    }
}

val xx=convertInt("3453").map(x=>x*2)
println("KKKK" + xx)

def sum(ints:List[Int]):Int={
  ints match {
    case Nil => 0
    case x => ints.head + sum(ints.tail)
  }
}

sum(List(1,2,3,4))


def sumR(ints:List[Int]):Int={
  def helper(i:List[Int],acc:Int):Int={
    i match {
      case Nil => acc
      case x :: t => helper(t, x + acc)
    }
  }
  helper(ints,0)
}

sumR(List(1,2,3,4))