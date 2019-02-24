package repostitories

/**
  * Created by andrew on 24/02/19.
  */
sealed trait Pet {

  val name:String
  val age:Int
  def speak:String

}

final case class Cat(override val name:String, age: Int ) extends Pet{
   def speak="Meow!"
}

final case class Dog (override val name:String,age: Int) extends Pet{
   def speak="woof!"
}





