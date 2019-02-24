sealed trait Pet {

  val name:String
  val age:Int
  def speak():String="Hello!"

}

final case class Cat(name:String,age:Int) extends Pet {
  override def speak()="Meow!"
}

final case class Dog (name:String,age:Int) extends Pet {
  override def speak()="woof!"
}

def whoDis(pet:Pet)={
  pet match {
    case Dog(name,age) if age==3 =>"A dog who is 3"
    case Dog(name,_)=>s"This is a dog and their name is $name"
    case Cat(name,_)=>s"This is a cat and their name is $name"
  }
}

whoDis(Dog("aaa",33))
