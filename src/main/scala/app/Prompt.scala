package app

/**
  * Created by andrew on 24/02/19.
  */
import scala.io.StdIn

object Prompt{
  def ask(message:String)=StdIn.readLine(message)

  def reply(message:String)=println(message)
}