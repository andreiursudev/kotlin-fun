package com.learning.c08inheritance

fun main(args: Array<String>) {
    val laserPrinter = LaserPrinter("Brother 1234", 15)
    laserPrinter.printModel()

    SomethingElse("whatever")
}

//classes are public and final by default
//open - means no final and can be extended
//abstract - abstract and not final
abstract class Printer(val modelName: String) {

    open fun printModel() = println("The model name of this printer is $modelName")
    abstract fun bestSellingPrice(): Double

}

//override also means open
open class LaserPrinter(modelName: String, ppm: Int) : Printer(modelName) {

    final override fun printModel() = println("The model name of this laser printer is $modelName")
    override fun bestSellingPrice(): Double = 129.99

}

class SpecialLaserPrinter(modelName: String, ppm: Int) : LaserPrinter(modelName, ppm) {
    //override fun printModel() = println("this is my way")
}


open class Something {
    val someProperty: String

    constructor(someParameter: String) {
        someProperty = someParameter
        println("I'm in the parent's constructor")
    }
}

class SomethingElse : Something {
    constructor(someOtherParameter: String) : super(someOtherParameter) {
        println("I'm in the child's constructor")
    }
}

//data classes are closed typed, they cannot be extended
data class DataClass(val number: Int){

}
