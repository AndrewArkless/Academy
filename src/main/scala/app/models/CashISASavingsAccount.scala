package app.models

/**
  * Created by andrew on 24/02/19.
  */
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