package com.learning.declarations

typealias EmployeeSet = Set<Employee>

fun main(args: Array<String>) {
    println("Hello World!")

    //val = final
    val number1: Int
    val number2 = 25
    val number3: Int = 25
    val number4: Short = 25
    //var = mutable
    var number5: Int
    number5 = 10

    val employee1 = Employee("Lynn Jones", 500)
    employee1.name = "Lynn Smith"

    //employee1 = Employee("Tim Watson", 100) cannot assign a new instance to employee1 reference variable

    val employees: EmployeeSet
}

class Employee(var name: String, val id: Int) {

}