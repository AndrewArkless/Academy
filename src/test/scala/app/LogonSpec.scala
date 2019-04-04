package app
import org.scalatest.{Matchers, WordSpec}
import org.scalatest.mockito._
import org.mockito.Mockito._
/**
  * Created by andrew on 20/03/19.
  */
class LogonSpec extends WordSpec with Matchers with MockitoSugar  {
  "Calling Logon" should {
    "log me on" in {
      val fakeDatabase=mock[callDataBase]
      when(fakeDatabase.grantAccess("Andrew")).thenReturn(false)
      val logon=new Logon {
        override val database =fakeDatabase
      }
      logon.loggingOn shouldBe false
    }
  }

  "Calling Logon fakedv" should {
    "log me on" in {
      class fakeDatabase(access:Boolean) extends callDataBase{
        override def grantAccess(s: String): Boolean = access
      }
      val logon=new Logon {
        override val database =new fakeDatabase(true)
      }
      logon.loggingOn shouldBe true
    }
  }

}
