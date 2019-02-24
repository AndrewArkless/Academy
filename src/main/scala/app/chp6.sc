import app.models.Person

import scala.collection.mutable.ArrayBuffer

val t:(Int,String,Person)=(1,"hello",new Person("aa",22))

val number=t._1
val string=t._2
val person=t._3

t.productElement(2)
t.productIterator.foreach(x=>println(x))

class Dog(name:String, val age:Int){
  import Dog._
  def getAge=calcAge(age)
}

object Dog{
  def withName(name:String)=new Dog(name,8)
  def apply(name:String,age:Int)=new Dog(name,age)
  private def calcAge(age:Int)=age*2
}

Dog.withName("aaaa").getAge
val a = Dog("jjj",3)


val x=ArrayBuffer("A","B","C")
val yy=x.indexOf("A")
x(0)="s"
x


val buf = ArrayBuffer(1,2,3,4,5,6,7,8,9,10)
buf.clone foreach { x => if (x % 2 == 0) buf -= x }
buf
