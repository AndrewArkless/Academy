package app

import org.scalatest.mockito._
import org.scalatest.{Matchers, WordSpec}
import org.mockito.Mockito._

/**
  * Created by andrew on 23/03/19.
  */
class DatabaseSpec extends WordSpec with Matchers with MockitoSugar{

  "calling Database" should {
    "return true when logged in" in {
      val mockConnector = mock[Connector]
      when(mockConnector.isLoggedOn).thenReturn(true)
      val db = new Database {
        override val connector = mockConnector
      }
      val result = db.logon
      assert(result == "logged on")
    }


    "return false when not logged in" in {
      val mockConnector = mock[Connector]
      when(mockConnector.isLoggedOn).thenReturn(false)
      val db = new Database {
        override val connector = mockConnector
      }
      val result = db.logon
      assert(result == "not Logged on")
    }
  }
}
