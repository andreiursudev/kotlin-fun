package com.learning.c07functions

fun main(args: Array<String>) {
    val s = "this is all in lowercase"
    //s is the receiver object
    println(s.upperFirstAndLast())
}

//String - the receiver type
//can use this.substring(0,1)
fun String.upperFirstAndLast(): String{
    val upperFirst = substring(0,1).uppercase() + substring(1)
    return upperFirst.substring(0, upperFirst.length -1) +
            upperFirst.substring(upperFirst.length -1, upperFirst.length).uppercase()
}