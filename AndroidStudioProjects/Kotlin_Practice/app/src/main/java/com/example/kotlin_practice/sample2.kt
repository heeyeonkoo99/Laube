package com.example.kotlin_practice

// 1. lamda
// 람다식은 우리가 마치 value처럼 다룰 수 있는 익명함수이다.
// 1) 메소드의 파라미터로 넘겨줄수가 있다. fun maxBy(a:Int)
// 2) return 값으로 사용할 수가 있다.

//람다의 기본정의
//val lamdaName:Type={argumentList ->codeBody}

val square:(Int)->(Int)={number:Int->number*number}
val nameAge:(String,Int)->String={name:String,age:Int->
    "my name is ${name} I'm ${age}"
}


fun main(){
    println(square(12))
    println(nameAge("joyce",23))
    val a="joyce said"
    val b="mac said"
    println(a.pizzaIsGreat())
    println(b.pizzaIsGreat())
    println(extendString("joyce",28))
    println(calculateGrade(97))

    val lamda:(Double)->Boolean={
        number:Double->number==4.3213
    }
    println(invokeLamda(lamda))
    println(invokeLamda({it>3.22}))
    println(invokeLamda{it>3.22}) //invoke함수처럼 function의 마지막 return값이 lamda일때는 이처럼 생략가능
}

// 확장함수
val pizzaIsGreat:String.()->String={
    this+" Pizza is the best!"
}

fun extendString(name:String,age:Int):String{
    val introduceMyself:String.(Int)->String={"I am ${this} and ${it} years old"} //파라미터가 하나만 들어가있는 경우 it으로도 부를수있음.
    return name.introduceMyself(age)
}

// 람다의 Return
val calculateGrade:(Int)->String={
    when(it){
        in 0..40->"fail"
        in 41..70->"pass"
        in 71..100->"perfect"
        else->"Error"
    }
}

//람다를 표현하는 여러가지 방법
fun invokeLamda(lamda:(Double)->Boolean):Boolean{
    return lamda(5.2343)
}

