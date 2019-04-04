package app

import org.scalatest.mockito._
import org.scalatest.{Matchers, WordSpec}
import org.mockito.Mockito._
import org.scalatest.mockito.MockitoSugar
class DisplayTimeSpec extends WordSpec with Matchers with MockitoSugar {

  "Calling DisplayTime" should {

    "must display morning if morning" in {
      val mockTimeOfDay=mock[realNow]
      when(mockTimeOfDay.partOfDay).thenReturn("morning")
      val time=new DisplayTime{
        override val timer=mockTimeOfDay
      }
      time.getTime shouldBe "morning"
    }
  }

}
