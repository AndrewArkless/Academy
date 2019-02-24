package app

import app.Prompt._
import app.models.{CashISASavingsAccount, Person}

object GreetingApplication extends App {

  val name =ask("What is your name?")
  val age=ask("What is your age?")
//  val p=new Person(name,age.toInt)
//  println(p.speak)

  val cashISASavingsAccount=new CashISASavingsAccount("45678",0.0,1000.00)
  val deposited=cashISASavingsAccount.deposit(1000.00)
  val withDrawn=deposited.withDraw(200.00)

  val person=new Person(name,age.toInt,withDrawn)
  println(person.speak())

  val normalAccount=new CashISASavingsAccount("12334",100.00)
  val loyalAccountDeposited=normalAccount.deposit(300.00)
  val loyal=new Person("loyal customer",22,loyalAccountDeposited)
  loyal.speak()

}
