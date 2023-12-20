package com.learning.c17lambdaexpressions

import academy.learnprogramming.lambdas.Employee


fun main(args: Array<String>) {

    //println(countTo100())


    val employees = listOf(
        Employee("John", "Smith", 2012),
        Employee("Jane", "Wilson", 2015),
        Employee("Mary", "Johnson", 2010),
        Employee("Mike", "Jones", 2002)
    )

    findByLastName(employees, "Wilson")
    findByLastName(employees, "Smithson")

    "Some String".apply somestring@{
        "Another String".apply {
            println(lowercase())
            println(this@somestring.uppercase())
        }
    }


}

fun findByLastName(employees: List<Employee>, lastName: String) {
    employees.forEach returnBlock@{
        if (it.lastName == lastName) {
            println("Yes, there's an employee with the last name $lastName")
            return@returnBlock //@returnBlock makes a non-local return to be a local return; will return from the forEach but not from the function
        }
    }

    println("Nope, there's no employee with the last name $lastName")
}

fun countTo100() = //using expression body
    StringBuilder().apply() {//uses a receiver object
        for (i in 1..99) {
            append(i)
            append(", ")
        }
        append(100)
    }.toString()

//fun countTo100() =

//        with(StringBuilder()) { //when lambda is the last argument to a function it can be typed immediately
//            for (i in 1..99) {
//                append(i)
//                append(", ")
//            }
//            append(100)
//            toString()
//        }


//fun countTo100(): String {
//    val numbers = StringBuilder()
//    for (i in 1..99) {
//        numbers.append(i)
//        numbers.append(", ")
//    }
//    numbers.append(100)
//    return numbers.toString()
//}

data class Employee(val firstName: String, val lastName: String, val startYear: Int) {

}
