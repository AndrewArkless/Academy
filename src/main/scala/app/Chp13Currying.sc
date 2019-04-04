def add(x:Int,y:Int)=x+y

def add1(x:Int)(y:Int)=x+y

def add2(x:Int)={
  (y:Int)=>x+y
}

val x=add2(2)
x(4)

add1(2)_

val sum=(a:Int,b:Int,c:Int)=>a+b+c

val f=sum(1,2,_ )

f(30)

