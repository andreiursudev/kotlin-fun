package com.learning.c23kotlincoroutinelibrary

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    GlobalScope.launch {
        delay(1000L)
        println("World 1!")
    }
    GlobalScope.launch {
        delay(1000L)
        println("World 2!")
    }
    GlobalScope.launch {
        delay(1000L)
        println("World 3!")
    }
    println("Hello,")
    Thread.sleep(2000L)
}