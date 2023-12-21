package com.learning.c21javainteroperability.calljava

import com.learning.c21javainteroperability.javacode.Car


fun main(args: Array<String>) {

    val car = Car("blue", "Ford", 2015)
    car.color = "green"
    println(car)

    car.variableMethod(5, "hello", "goodbye")
    val strings = arrayOf("hello", "goodbye")
    car.variableMethod(10, *strings)

    car.wantsIntArray(intArrayOf(1, 2, 3))

    //Object in Java is Any in Kotlin
    //Any only has toString, hashCode and equals functions.It does not have wait, notify, getClass or the clone or the finalize methods that the object class has.
    //(car.anObject as java.lang.Object).notify()
    //car.anObject.javaClass

    println("x = ${Car.x}")
    println(Car.xString())


    //you can pass a function as a lambda
    car.demoMethod({ println("I'm in a thread!") })



    //String - notnullable type
    //String? - nullable type
    //Platform types cannot be created in Kotlin.I Kotlin you can have String or String? but not both in the same time as Java String
    //var model: String = car.model
    //println(model.javaClass)
    //model = null
    //println(model)

    //val color: Int = car.color

}