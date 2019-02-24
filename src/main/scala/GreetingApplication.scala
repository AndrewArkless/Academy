package app

import scala.io.StdIn

abstract class BankAccount(accountNumber:String, val balance:Double) {

  def withDraw(amount:Double):BankAccount
  def deposit(amount:Double):BankAccount
  override def toString:String=s"Account Number: $accountNumber, balance : $balance"
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

final class CashISASavingsAccount(accountNumber:String, balance:Double,depositThreshold:Double=200)
    extends BankAccount(accountNumber,balance) {

  override def withDraw(amount: Double): CashISASavingsAccount = {
    println("You cannout withdraw")
    this
  }

  override def deposit(amount:Double):CashISASavingsAccount={
    if (amount>depositThreshold){
      val difference=amount-depositThreshold
      println(s"You cannot deposit more than £$depositThreshold Excess £$difference.")
      new CashISASavingsAccount(accountNumber,balance+depositThreshold)
    } else {
      new CashISASavingsAccount(accountNumber, amount + balance)
    }
  }
}

class Person(name:String, age:Int, private val bankAccount: BankAccount){

  def this(name:String,age:Int)=
    {
       this(name,age,new SavingsAccount("12345",0.00))
    }

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
        s"Hello $name you are $age $years old \n and your bank details are $bankAccount"
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
