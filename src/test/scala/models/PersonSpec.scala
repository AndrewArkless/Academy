package models

import app.models.{Person, getTime}
import org.scalatest.{Matchers, WordSpec}
import org.mockito.Mockito._
import org.scalatest.mockito.MockitoSugar
/**
  * Created by andrew on 09/03/1       val person=new Person("adam",10){
         override def clock:getTime=getTimeMock
        }9.
  */
class PersonSpec extends WordSpec with Matchers with MockitoSugar {
  val getTimeMock=mock[getTime]
  val person=new Person("adam",10){
    override val clock:getTime=getTimeMock
  }

  "Person" when {
    "Speak is called" should {
      "return you don't get a hello" in {
        when(getTimeMock.clock).thenReturn("Sunday")

      //  assert(person.speak().equals("you don't get a hello"))
        person.speak() shouldBe "you don't get a hello Sunday"
      }
    }
  }

}
