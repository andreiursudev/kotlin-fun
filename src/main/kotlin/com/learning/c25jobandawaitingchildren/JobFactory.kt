package com.learning.c25jobandawaitingchildren

import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main(): Unit = coroutineScope {
    //A common mistake is to create a job using the Job() factory function, use it as a parent for some coroutines, and then use join on the job.
    //Such a program will never end because Job is still in an active state, even when all its children are finished.
    // This is because this context is still ready to be used by other coroutines.
    val job = Job()
    launch(job) { // the new job replaces one from parent
        delay(1000)
        println("Text 1")
    }
    launch(job) { // the new job replaces one from parent
        delay(2000)
        println("Text 2")
    }
    job.join() // Here we will await forever
    println("Will not be printed")

    //Better approach
    val job2 = Job()
    launch(job2) { // the new job replaces one from parent
        delay(1000)
        println("Text 1")
    }
    launch(job2) { // the new job replaces one from parent
        delay(2000)
        println("Text 2")
    }
    job2.children.forEach { it.join() }
}