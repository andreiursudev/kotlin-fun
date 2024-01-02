package com.learning.c25jobandawaitingchildren

import kotlinx.coroutines.*

fun main(): Unit = runBlocking {
    //Every coroutine builder from the Kotlin coroutines library creates its own job
    val job1: Job = launch {
        delay(1000)
        println("Test")
    }

    val deferred: Deferred<String> = async {
        delay(1000)
        "Test"
    }
    val job2: Job = deferred

    //Since Job is a coroutine context, we can access it using coroutineContext[Job]. However, there’s also an extension property job, which lets us access the job more efficiently.
    print(coroutineContext.job.isActive) // true


    //There is an essential rule we need to pay attention to: Job is the only coroutine context that we cannot inherit by a coroutine from a coroutine.
    //Every coroutine creates its own Job, and the job from an argument or parent coroutine is used as a parent of this new job.
    val name = CoroutineName("Some name")
    val job = Job()

    launch(name + job) {
        val childName = coroutineContext[CoroutineName]
        println(childName == name) // true
        val childJob = coroutineContext[Job]
        println(childJob == job) // false
        println(childJob == job.children.first()) // true
    }
}