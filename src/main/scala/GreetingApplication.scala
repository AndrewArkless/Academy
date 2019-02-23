package app

import scala.io.StdIn

abstract class BankAccount(accountNumber:String, balance:Double) {

  def withDraw(amount:Double):BankAccount
  def deposit(amount:Double):BankAccount

}

final class SavingsAccount(accountNumber:String, balance:Double) extends BankAccount(accountNumber,balance){
  override def withDraw(amount:Double):BankAccount ={
    if((balance-amount<0)){
      println(s"You have insufficient funds")
      this
    }
    val deducted=balance-amount
    println(s"balance after deduction: $deducted")
    new SavingsAccount(accountNumber,deducted)
  }

  override def deposit(amount:Double):BankAccount={
    new SavingsAccount(accountNumber,amount+balance)
  }
}

final class CashISASavingsAccount(accountNumber:String, balance:Double) extends BankAccount(accountNumber,balance) {
  override def withDraw(amount: Double): BankAccount = {
    println("You cannout withdraw")
    this
  }

  override def deposit(amount:Double):BankAccount={
    new SavingsAccount(accountNumber,amount+balance)
  }
}

class Person(name:String, age:Int){
  private val years:String={
    if (age>1) {
      "years"
    }
    else {
      "year"
    }
  }

  def speak():String ={
    if (name=="adam") {
        s"you don't get a hello"
    } else {
        s"Hello $name you are $age $years old"
    }
  }
}

object Prompt{
  def ask(message:String)=StdIn.readLine(message)
}
object GreetingApplication extends App {
import Prompt._

  val name =ask("What is your name?")
  val age=ask("What is your age?")
  val p=new Person(name,age.toInt)
  println(p.speak)
}
