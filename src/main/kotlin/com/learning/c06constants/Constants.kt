package com.learning.c04accessmodifiers

val MY_CONSTANT = 100

fun main(args: Array<String>) {
    println(MY_CONSTANT)

    val car = Car("blue", "Toyota", 2015)
    println(car)

    val car2  = car.copy(year = 2016)
    println(car2)
}

//data class has toString, hashCode, equals, copy functions
data class Car(val color: String, val model: String, val year: Int) {

}
