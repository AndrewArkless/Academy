val x=List[Int](1,2,3,4,5,6,7)
x.foldLeft(0)((a,b)=>a+b)
def add(a:Int,b:Int)={
  a+b
}

x.foldLeft(0)(add)
val add1=(a:Int,b:Int)=>a+b

x.foldLeft(0)(add1)

x.map(x=>x).sum

def sumAndMulitply(f:Int=>Int)={
  x.map(f(_)).sum
}

sumAndMulitply(_*2)

val divide=(x:Int)=>42/x

//divide(0)

val divide1 = new PartialFunction[Int,Int] {
  def apply(x:Int)=42/x
  def isDefinedAt(x:Int)=x !=0
}

if (divide1.isDefinedAt(1)) divide1(1)

val divide2: PartialFunction[Int,Int]={
  case d:Int if d !=0 => 42/d
}

val y=List(0,2,3,0,0,0,0,4,5,0)
y.collect(divide2)


val isEven:PartialFunction[Int,String]={
  case e:Int if e %2== 0 => s"$e is even"
}

val isOdd:PartialFunction[Int,String]={
  case o:Int if o %2!= 0 => s"$o is odd"
}
val r=1 to 20

val isOddOrEven=isEven orElse isOdd
r.collect(isOddOrEven)

val double=(n:Int)=>n*2
val plusOne=(n:Int)=>n+1

val doublePlusOne=double andThen plusOne
val doublePlusOneComposed=double compose plusOne

x.map(doublePlusOne)
x.map(doublePlusOneComposed)


doublePlusOne(2)

doublePlusOneComposed(2)

val vowels=new PartialFunction[Char,Char]{
  def apply(s:Char)=s.toUpper
  def isDefinedAt(s:Char)=List('a','e','i').contains(s)

}


if (vowels.isDefinedAt('b')) vowels('b')

List('a','e','i').contains('a')
