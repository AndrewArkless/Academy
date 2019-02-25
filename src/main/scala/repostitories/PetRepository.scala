package repostitories

import scala.collection.mutable.ArrayBuffer

/**
  * Created by andrew on 24/02/19.
  */
object PetRepository {

  private val _pets=new ArrayBuffer[Pet]

  def all():List[Pet]= _pets.toList
  def findByName(name:String):Option[Pet]=_pets.find(p=>p.name == name)
  def dogs():List[Dog]=_pets.toList.flatMap{
    case c @ Dog(_,_)=>Some(c)
    case _ => None
  }
  def cats():List[Cat]=_pets.toList.flatMap{
    case c @ Cat(_,_)=>Some(c)
    case _ => None
  }
  def other():List[Pet]=_pets.toList.flatMap{
    case c @ Cat(_,_)=>None
    case d @ Dog(_,_)=>None
    case x @ _ =>Some(x)
  }

  def add(pet: Pet*):List[Pet]={
       (_pets ++= pet).toList
  }

  def removeByName(name:String):List[Pet]={
   _pets filter{p=>p.name==name} foreach{ _pets -= _ }
    _pets.toList
  }

  def update(pet:Pet):List[Pet]= {
    _pets filter{p=>p.name==pet.name} foreach{ _pets -= _ }
    _pets += pet

    _pets.toList
  }

}

object petTest extends App {
  val a=Dog("AAA",22)
  val b=Cat("BB",22)
  val c=Dog("CCC",22)
  val d=Cat("ddddd",22)
  val e=Dog("CCC",44)
  PetRepository.add(a,b,c,d)
  println(PetRepository.findByName("AAA"))
  println(PetRepository.dogs())
  println(PetRepository.removeByName("AAA"))
  println(PetRepository.update(e))
  println(PetRepository.all())

}