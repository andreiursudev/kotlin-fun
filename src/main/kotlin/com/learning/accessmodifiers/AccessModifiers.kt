package com.learning.accessmodifiers

//private - visible within the same file
//protected - can't be used
//public(default) - visible everywhere
//internal - visible within the same module -> converted to public in Java(with ugly class names)

fun main(args: Array<String>) {
    val emp = Employee()
    println(emp)
}

private class Employee {

}