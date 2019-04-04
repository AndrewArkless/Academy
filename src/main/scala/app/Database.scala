package app

/**
  * Created
  * by andrew on 23/03/19.
  */

class Connector{
  def isLoggedOn=true
}
class Database {
  val connector=new Connector
  def logon=if (connector.isLoggedOn) "logged on" else "not Logged in"
}
