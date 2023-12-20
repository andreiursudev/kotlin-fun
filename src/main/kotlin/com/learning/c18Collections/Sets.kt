package com.learning.c18Collections

fun main(args: Array<String>) {
    val setInts = setOf(10, 15, 19, 5, 3, -22)
    println(setInts.plus(20))
    println(setInts.plus(10))
    println(setInts.minus(19))
    println(setInts.minus(100))
    println(setInts.average())
    println(setInts.drop(3))

    val mutableInts = mutableSetOf(1, 2, 3, 4, 5)
    mutableInts.plus(10)
    println(mutableInts)
}