package com.learning.c18collections


fun main(args: Array<String>) {

    val strings = listOf("spring", "summer", "fall", "winter") //a collection is immutable we mean that it's guaranteed to be immutable from Kotlin but not in Java
    println(strings.javaClass)
    println(strings.asReversed())
    println(strings)

    val emptyList = emptyList<String>()
    println(emptyList.javaClass)

    if (!emptyList.isEmpty()) {
        println(emptyList[0])
    }

    val notNullList = listOfNotNull("hello", null, "goodbye")//null is not added to the list
    println(notNullList)

    val arraylist = arrayListOf(1, 2, 4)//this is a Java mutable ArrayList
    println(arraylist.javaClass)

    val mutableList = mutableListOf<Int>(1, 2, 3)
    println(mutableList.javaClass)

    println(mutableList[2])
    mutableList[1] = 20
    println(mutableList)


    val array = arrayOf("black", "white", "green")
    val colorList = array.toList()
    println(colorList)


    val ints = intArrayOf(1, 2, 3)
    println(ints.toList())
}