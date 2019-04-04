package app.models




/**
  * Created by andrew on 24/02/19.
  */
//object getTime extends getTime {
//  def now = "Saturday"
//}

//object getTime extends getTime {
//  def now="Saturday"
//}
//
class realGetTime extends getTime
{
  override val clock="Saturday"
}
trait getTime {
  val clock:String
}

//trait Person1 {
//  def clock:getTime
//}

class Person(name:String, age:Int, private val bankAccount: Seq[BankAccount]=Nil)
{
   val timer = new realGetTime

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
      s"you don't get a hello ${timer.clock}"
    } else {
      s"Hello $name you are $age $years old \n and your bank details are $bankAccount"
    }
  }


}