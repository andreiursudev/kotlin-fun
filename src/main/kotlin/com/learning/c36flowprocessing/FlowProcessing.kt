package com.learning.c36flowprocessing

import kotlinx.coroutines.flow.*

suspend fun main() {
    println("Using map")
    flowOf(1, 2, 3) // [1, 2, 3]
        .map { it * it } // [1, 4, 9]
        .collect { print(it) } // 149


    println("Using filter")
    (1..10).asFlow() // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        .filter { it <= 5 } // [1, 2, 3, 4, 5]
        .filter { isEven(it) } // [2, 4]
        .collect { print(it) } // 24


    println("Using take")
    ('A'..'Z').asFlow()
        .take(5) // [A, B, C, D, E]
        .collect { print(it) } // ABCDE


    println("Using drop")
    ('A'..'Z').asFlow()
        .drop(20) // [U, V, W, X, Y, Z]
        .collect { print(it) } // UVWXYZ
}

fun isEven(num: Int): Boolean = num % 2 == 0