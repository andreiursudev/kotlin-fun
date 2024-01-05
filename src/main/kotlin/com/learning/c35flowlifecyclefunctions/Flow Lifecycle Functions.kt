package com.learning.c35flowlifecyclefunctions

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

suspend fun main() {
    println("Adding delay in onEach()")
    flowOf(1, 2)
        .onEach { delay(1000) }
        .collect { println(it) }

    println("Using the onStart function")
    flowOf(1, 2)
        .onEach { delay(1000) }
        .onStart { println("Before") }
        .collect { println(it) }

    println("Emitting elements in onStart()")
    flowOf(1, 2)
        .onEach { delay(1000) }
        .onStart { emit(0) }
        .collect { println(it) }

    println("Using the onCompletion function")
    flowOf(1, 2)
        .onEach { delay(1000) }
        .onCompletion { println("Completed") }
        .collect { println(it) }

    println("Another way of using onCompletion()")
    coroutineScope {
        val job = launch {
            flowOf(1, 2)
                .onEach { delay(1000) }
                .onCompletion { println("Completed") }//is still called
                .collect { println(it) }
        }
        delay(1100)
        job.cancel()
    }


    flow<List<Int>> { delay(1000) }
        .onEmpty { emit(emptyList()) }
        .collect { println(it) }
}