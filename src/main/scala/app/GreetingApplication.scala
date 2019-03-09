package app

import app.Prompt._
import app.models.{CashISASavingsAccount, Person}

import scala.util.{Failure, Success, Try}

object GreetingApplication extends App {


//  def getAge():Int={
//    val age=ask("What is your age?")
//    try{
//      age.toInt
//    } catch {
//      case _ :Throwable => {
//        println("ERRROR")
//        getAge()
//      }
//    }
//  }

  def getAge():Int= {
    Try {
      ask("What is tyou age").toInt
    } match {
      case Success(a) => a
      case Failure(e) => getAge
    }
  }
  val name =ask("What is your name?")
  val age=getAge
//  val p=new Person(name,age.toInt)
//  println(p.speak)

  val cashISASavingsAccount=new CashISASavingsAccount("45678",0.0,1000.00)
  val deposited=cashISASavingsAccount.deposit(1000.00)
  val withDrawn=deposited.withDraw(200.00)

  val person=new Person(name,age,List(withDrawn))
  println(person.speak())

  val normalAccount=new CashISASavingsAccount("12334",100.00)
  val loyalAccountDeposited=normalAccount.deposit(300.00)
  val loyal=new Person("loyal customer",22,List(loyalAccountDeposited))
  loyal.speak()

}
