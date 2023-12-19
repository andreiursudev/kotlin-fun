package com.learning.c07functions


//default return for function is Unit
fun main(args: Array<String>) {
    println(labelMultiply(3, 4, "The result is:"))
    println(labelMultiply3(3, 4))

    //using named arguments
    println(labelMultiply3(operand1 = 3, operand2 = 4))

    val emp = Employee("Jane")
    println(emp.upperCaseFirstName())

    val car1 = Car("blue", "Toyota", 2015)
    val car2 = Car("red", "Ford", 2016)
    val car3 = Car("grey", "Ford", 2017)

    printColors("Color:", car1, car2, car3)

    val numbers = arrayOf(1, 2, 3)

    val manyCars = arrayOf(car1, car2, car3)
    //* - spread operator=unpacks the array
    printColors2(*manyCars)

    val moreCars = arrayOf(car2,car3)
    val car4 = car2.copy();

}

//function with block body
fun labelMultiply(operand1: Int, operand2: Int, label: String): String {
    return ("$label ${operand1 * operand2}")
}

//function with expression body
fun labelMultiply2(operand1: Int, operand2: Int, label: String) =
    "$label ${operand1 * operand2}"

fun labelMultiply3(operand1: Int, operand2: Int, label: String = "The answer is:") =
    "$label ${operand1 * operand2}"


class Employee(val firstName: String) {
    fun upperCaseFirstName() = firstName.uppercase()
}

data class Car(val color: String, val model: String, val year: Int) {

}

fun printColors(str: String, vararg cars: Car) {
    for (car in cars) {
        println(car.color)
    }
}

fun printColors2(vararg cars: Car) {
    for (car in cars) {
        println(car.color)
    }
}