package com.learning.c24coroutinecontext

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

fun main() {
    //Adding contexts
    val ctx1: CoroutineContext = CoroutineName("Name1")
    println(ctx1[CoroutineName]?.name) // Name1
    println(ctx1[Job]?.isActive) // null

    val ctx2: CoroutineContext = Job()
    println(ctx2[CoroutineName]?.name) // null
    println(ctx2[Job]?.isActive) // true, because "Active"
    // is the default state of a job created this way

    val ctx3 = ctx1 + ctx2
    println(ctx3[CoroutineName]?.name) // Name1
    println(ctx3[Job]?.isActive) // true


    //When we add another element with the same key, like in a map, the new element replaces the previous one.
    val ctx4: CoroutineContext = CoroutineName("Name1")
    println(ctx4[CoroutineName]?.name) // Name1

    val ctx5: CoroutineContext = CoroutineName("Name2")
    println(ctx5[CoroutineName]?.name) // Name2

    val ctx6 = ctx4 + ctx5
    println(ctx6[CoroutineName]?.name) // Name2


    //Empty coroutine context
    val empty: CoroutineContext = EmptyCoroutineContext
    println(empty[CoroutineName]) // null
    println(empty[Job]) // null

    val ctxName = empty + CoroutineName("Name1") + empty
    println(ctxName[CoroutineName]) // CoroutineName(Name1)

    //Subtracting elements
    val ctx7 = CoroutineName("Name1") + Job()
    println(ctx7[CoroutineName]?.name) // Name1
    println(ctx7[Job]?.isActive) // true

    val ctx8 = ctx7.minusKey(CoroutineName)
    println(ctx8[CoroutineName]?.name) // null
    println(ctx8[Job]?.isActive) // true

    val ctx9 = (ctx7 + CoroutineName("Name2"))
        .minusKey(CoroutineName)
    println(ctx9[CoroutineName]?.name) // null
    println(ctx9[Job]?.isActive) // true
}