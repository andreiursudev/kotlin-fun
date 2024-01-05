package com.learning.c35flowlifecyclefunctions

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext

class MyError : Throwable("My error")

val flow = flow {
    emit(1)
    emit(2)
    throw MyError()
}

fun usersFlow(): Flow<String> = flow {
    repeat(2) {
        val ctx = currentCoroutineContext()
        val name = ctx[CoroutineName]?.name
        emit("User$it in $name")
    }
}

suspend fun main(): Unit {
    println("Using catch")
    flow.onEach { println("Got $it") }
        .catch { println("Caught $it") }
        .collect { println("Collected $it") }

    println("Emit values using catch")
    flow.catch { emit(10) }
        .collect { println("Collected $it") }

    println("Catching exceptions using try-catch block")
    try {
        flow.collect { println("Collected $it") }
    } catch (e: MyError) {
        println("Caught")
    }

    println("Functions taking context from where collect is called")
    val users = usersFlow()
    withContext(CoroutineName("Name1")) {
        users.collect { println(it) }
    }
    withContext(CoroutineName("Name2")) {
        users.collect { println(it) }
    }

    println("Using launchIn")
    coroutineScope {
        flowOf("User1", "User2")
            .onStart { println("Users:") }
            .onEach { println(it) }
            .launchIn(this)
    }
}