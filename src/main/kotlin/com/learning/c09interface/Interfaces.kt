package com.learning.c09interface

fun main(args: Array<String>) {

}

open class Something : MySubInterface {
    override val number: Int = 25


    override fun mySubFunction(str: String): String {
        TODO("Not yet implemented")
    }

    override fun myFunction(str: String): String {
        TODO("Not yet implemented")
    }

}

interface MyInterfaces {
    val number: Int
    val number2: Int
        get() = number * 100

    fun myFunction(str: String): String
}

interface MySubInterface : MyInterfaces {
    fun mySubFunction(str: String): String
}