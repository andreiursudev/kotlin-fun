package com.learning.c23kotlincoroutinelibrary

import kotlinx.coroutines.*

fun main() = runBlocking {
    this.launch { // same as just launch
        delay(1000L)
        println("World 1!")
    }
    launch { // same as this.launch
        delay(2000L)
        println("World 2!")
    }
    println("Hello,")
}