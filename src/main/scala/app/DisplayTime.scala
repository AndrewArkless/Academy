package app

//trait now {
//  def partOfDay():String
//}

class realNow {
  def partOfDay()="afternoon"
}
class DisplayTime {
   val timer=new realNow
   def getTime=timer.partOfDay()
}
