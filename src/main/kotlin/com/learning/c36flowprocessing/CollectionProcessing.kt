package com.learning.c36flowprocessing

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

suspend fun main() {

    println("Using the merge function")
    val ints: Flow<Int> = flowOf(1, 2, 3)
    val doubles: Flow<Double> = flowOf(0.1, 0.2, 0.3)

    val together: Flow<Number> = merge(ints, doubles)
    println(together.toList())
    // [1, 0.1, 0.2, 0.3, 2, 3]
    // or [1, 0.1, 0.2, 0.3, 2, 3]
    // or [0.1, 1, 2, 3, 0.2, 0.3]
    // or any other combination
    val together2: Flow<Number> = merge(ints, doubles)
    together2.collect { println(it) }


    println("Using zip( )")
    val flow1 = flowOf("A", "B", "C")
        .onEach { delay(400) }
    val flow2 = flowOf(1, 2, 3, 4)
        .onEach { delay(1000) }
    flow1.zip(flow2) { f1, f2 -> "${f1}_${f2}" }
        .collect { println(it) }


    println("Using combine")
    val flow3 = flowOf("A", "B", "C")
        .onEach { delay(400) }
    val flow4 = flowOf(1, 2, 3, 4)
        .onEach { delay(1000) }
    flow3.combine(flow4) { f1, f2 -> "${f1}_${f2}" }
        .collect { println(it) }


    println("Using the fold function")
    val list = listOf(1, 2, 3, 4)
    val res = list.fold(0) { acc, i -> acc + i }
    println(res) // 10

    println("Using scan it’s an intermediate operation that produces all intermediate accumulator values.")
    val list2 = listOf(1, 2, 3, 4)
    val res2 = list2.scan(0) { acc, i -> acc + i }
    println(res2) // [0, 1, 3, 6, 10]
}