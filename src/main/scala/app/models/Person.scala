package app.models

/**
  * Created by andrew on 24/02/19.
  */
class Person(name:String, age:Int, private val bankAccount: Seq[BankAccount]=Nil){

  private val excluded=List("adam","daniel")

  def this(name:String,age:Int)=
  {
    this(name,age,Seq(new SavingsAccount("12345",0.00)))
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
    if (excluded.contains(name)) {
      s"you don't get a hello"
    } else {
      s"Hello $name you are $age $years old \n and your bank details are $bankAccount"
    }
  }
}