package app.models

abstract class BankAccount(accountNumber:String, val balance:Double) {

  def withDraw(amount:Double):BankAccount
  def deposit(amount:Double):BankAccount
  override def toString:String=s"Account Number: $accountNumber, balance : $balance"
}


