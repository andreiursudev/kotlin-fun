package com.learning.c23kotlincoroutinelibrary

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        delay(1000L)
        println("World 1!")
    }
    runBlocking {
        delay(1000L)
        println("World 2!")
    }
    runBlocking {
        delay(1000L)
        println("World 3!")
    }
    println("Hello,")
}