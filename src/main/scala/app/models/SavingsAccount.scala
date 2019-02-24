package app.models

/**
  * Created by andrew on 24/02/19.
  */
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
