package models

import app.models.{Person, getTime, realGetTime}
import org.scalatest.{Matchers, WordSpec}
import org.mockito.Mockito._
import org.scalatest.mockito.MockitoSugar

class PersonSpec extends WordSpec with Matchers with MockitoSugar {

  "Person" when {
    "Speak is called" should {
      "return you don't get a hello" in {
        val getTimeMock=mock[realGetTime]
        when(getTimeMock.clock).thenReturn("Sunday")
        val person=new Person("adam",10){
          override val timer=getTimeMock
        }
        //  assert(person.speak().equals("you don't get a hello"))
        person.speak() shouldBe "you don't get a hello Sunday"
      }
    }
  }

}
