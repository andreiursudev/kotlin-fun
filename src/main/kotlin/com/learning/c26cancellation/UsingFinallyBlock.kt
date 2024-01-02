package com.learning.c26cancellation

import kotlinx.coroutines.*
import kotlin.random.Random

suspend fun main(): Unit = coroutineScope {
    //A canceled coroutine is not just stopped—it’s canceled internally using an exception.
    //Therefore, we can freely clean up everything inside the finally block.
    val job = Job()
    launch(job) {
        try {
            delay(Random.nextLong(2000))
            println("Done")
        } finally {
            print("Will always be printed")
        }
    }
    delay(1000)
    job.cancelAndJoin()
}