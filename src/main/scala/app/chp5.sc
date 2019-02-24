for(a <- 1 to 10){
  println(a)
}

for(a <- 1 until 10){
  println(a)
}

for(a <- Range(1,10) if a != 4; if a % 2==0 ){
  println(a)
}

val names=List("Adam","david","daniel","david")

val ages=List(1,25,31,14)

val filtered=for(
  name <-names; if name != "david"; if name !="daniel";
  age <- ages
) yield s"name: $name age $age"

println(filtered)

