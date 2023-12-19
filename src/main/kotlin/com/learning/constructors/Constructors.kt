package com.learning.accessmodifiers

fun main(args: Array<String>) {
    val emp2 = Employee2("John")
    println(emp2)

    val emp6 = Employee6("Joe")
    println(emp6.firstName)
    println(emp6.fullTime)

    val demo = Demo()

    println(demo.dummy)
}

class Employee2 constructor(firstName: String) {
    val firstName: String

    //initializer block - runs when an instance is created, used in conjunction with the constructor
    init {
        this.firstName = firstName
    }
}

class Employee3 constructor(val firstName: String) {

}

class Employee4(val firstName: String) {

}

class Employee5 protected constructor(val firstName: String) {

}

class Employee6(val firstName: String) {

    var fullTime: Boolean = true

    constructor(firstName: String, fullTime: Boolean) : this(firstName) {

    }
}

class Employee7(val firstName: String, var fullTime: Boolean = true) {

}

class Demo {
    val dummy: String

    constructor() {
        dummy = "Hello"
    }
}