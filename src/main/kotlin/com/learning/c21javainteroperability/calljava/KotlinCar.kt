@file:JvmName("StaticCar")

package com.learning.c21javainteroperability.calljava

fun topLevel() = println("I'm in the Car file!")

fun main(args: Array<String>) {
    "Print this".print()
}

class KotlinCar(val color: String, @JvmField val model: String, val year: Int) {

//    var color: String = color
//        private set(value) {
//            field = "always green"
//        }

}

fun String.print() {
    println(this)
}