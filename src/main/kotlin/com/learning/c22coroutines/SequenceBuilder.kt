package com.learning.c22coroutines

import java.math.BigInteger

val seq1 = sequence {
    yield(1)
    yield(2)
    yield(3)
}


val seq2 = sequence {
    println("Generating first")
    println("Generating test")
    yield(1)
    println("Generating second")
    yield(2)
    println("Generating third")
    yield(3)
    println("Done")
}

val fibonacci: Sequence<BigInteger> = sequence {
    var first = 0.toBigInteger()
    var second = 1.toBigInteger()
    while (true) {
        yield(first)
        val temp = first
        first += second
        second = temp
    }
}

fun main() {
    print(fibonacci.take(10).toList())


    for (num in seq1) {
        print(num)
    } // 123



    val iterator = seq2.iterator()
    println("Starting")
    val first = iterator.next()
    println("First: $first")
    val second = iterator.next()
    println("Second: $second")
    // ...
}