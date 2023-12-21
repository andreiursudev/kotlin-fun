@file:JvmName("StaticCar")

package com.learning.c21javainteroperability.calljava

import java.io.IOException

fun topLevel() = println("I'm in the Car file!")

fun main(args: Array<String>) {
    "Print this".print()
    KotlinCar.carComp()
}

//Only ine version of the function is generated from Kotlin to Java, the one with all parameters
@JvmOverloads
fun defaultArgs(str: String, num: Int = 25) {

}

@Throws(IOException::class)//We need to annotate the exception since Kotlin only uses runtime exceptions
fun doIO() {
    throw IOException()
}

object SingletonObj {
    @JvmStatic
    fun doSomething() = println("I'm doing something in the singleton object")
}

class KotlinCar(val color: String, @JvmField val model: String, val year: Int) {

//    var color: String = color
//        private set(value) {
//            field = "always green"
//        }

    companion object {
        const val constant = 25
        @JvmField
        val isAuto = false
        @JvmStatic
        fun carComp() = println("I'm in Car's companion object")
    }

    fun printMe(text: String) {
        println("I don't expect a null value")
    }


}

fun String.print() {
    println(this)
}