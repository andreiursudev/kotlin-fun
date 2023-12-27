package com.learning.c22coroutines

import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

//When suspended, it does not consume any resources.
//We can resume a coroutine on a different thread, and (at least in theory) a continuation can be serialized, deserialized, and then resumed.
suspend fun main() {
    println("Before1")
    suspendCoroutine<Unit> { continuation ->
        println("Before1 too")

        continuation.resume(Unit)
    }
    println("After1")

    println("Before2")

    suspendCoroutine<Unit> { continuation ->
        thread {
            println("Suspended2")
            Thread.sleep(1000)
            continuation.resume(Unit)
            println("Resumed2")
        }
    }

    println("After2")

    //When we call suspendCoroutine, we can specify which type will be returned in its continuation. The same type needs to be used when we call resume.
    val i: Int = suspendCoroutine<Int> { cont ->
        cont.resume(42)
    }
    println(i)

    val str: String = suspendCoroutine<String> { cont ->
        cont.resume("Some text")
    }
    println(str)

    val b: Boolean = suspendCoroutine<Boolean> { cont ->
        cont.resume(true)
    }
    println(b)
}