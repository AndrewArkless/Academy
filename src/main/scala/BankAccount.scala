package app

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