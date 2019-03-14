abstract class Animal{
  def makeNoise()="NOISE!"
}

trait Friendly{
  def x:String
  def listen()=s"I am Listening i am $x."
}

class Human(name:String) extends Animal with Friendly{
  val x=name
}
class Dog(name:String) extends Animal
class Cat(name:String) extends Animal with Friendly{
  override def x: String = name
}
val me=new Human("ANdrew")


val cat=new Cat("Nicky")
cat.listen()
cat.makeNoise()

val dog=new Dog("Rover")

trait Equality{
  def isEquals:Boolean
  def isNotEqual = !isEquals
}
class Name(n:Name) extends Equality {
  override def isEquals: Boolean = n =="ANdrew"
}
class Address(a:Address) extends Equality


