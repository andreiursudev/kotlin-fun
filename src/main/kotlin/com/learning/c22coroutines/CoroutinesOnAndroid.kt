package com.learning.c22coroutines;

import kotlin.concurrent.thread

fun main(args: Array<String>) {

}

val view = View()

//Unfortunately, we cannot do this so easily.
// Each Android application only has one thread that can modify the view.
// This thread is essential and should never be blocked. That's why we cannot implement the function above in this way.
// If we started on the main thread, getNewsFromApi() would block it, and our application would crash.
// If we started it on another thread, our application would crash when we call showNews() because it needs to run on the main thread.
fun onCreate() {
    val news = getNewsFromApi()
    val sortedNews = news
        .sortedByDescending { it.publishedAt }
    view.showNews(sortedNews)
}

//switching threads, first to a thread that can be blocked and then to the main thread.
fun onCreate2() {
    thread {
        val news = getNewsFromApi()
        val sortedNews = news
            .sortedByDescending { it.publishedAt }
        runOnUiThread {
            view.showNews(sortedNews)
        }
    }
}

//Callbacks
fun onCreate3() {
    getNewsFromApi { news ->
        val sortedNews = news
            .sortedByDescending { it.publishedAt }
        view.showNews(sortedNews)
    }
}

// Cancellation
// Notice that this implementation does not support cancellation.
// We might make cancellable callback functions, but it's not easy.
// Not only does each callback function need to be specially implemented for cancellation, but to cancel them we need to collect all the objects separately.
fun onCreate4() {
    var startedCallbacks = getNewsFromApi { news ->
        val sortedNews = news
            .sortedByDescending { it.publishedAt }
        view.showNews(sortedNews)
    }
}

//Complex case
fun showNews() {
    getConfigFromApi { config ->
        getNewsFromApi(config) { news ->
            getUserFromApi { user ->
                view.showNews(user, news)
            }
        }
    }
}

//RxJava example
//This code is genuinely concurrent and has no memory leaks, but we need to introduce RxJava functions such as zip, flatMap, pack a value into Pair, and destructure it.
//This a correct implementation, but it's quite complicated.
/*fun showNews() {
    disposables += Observable.zip(
        getConfigFromApi().flatMap {
            getNewsFromApi(it) },
        getUserFromApi(),
        Function2 { news: List<News>, config: Config ->
            Pair(news, config)
        })
        .subscribeOn(Schedulers.io()).
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe { (news, config) ->
            view.showNews(news, config)
        }
}*/

val viewModelScope = ViewModelScope()

//Using Kotlin coroutines
fun showNews2() {

    viewModelScope.launch {
        val config = getConfigFromApi()
        val news = getNewsFromApi(config)
        val user = getUserFromApi()
        view.showNews(user, news)
    }
}

//useing the async/await pattern
/*fun showNews3() {
    viewModelScope.launch {
        val config = async { getConfigFromApi() }
        val news = async { getNewsFromApi(config.await()) }
        val user = async { getUserFromApi() }
        view.showNews(user.await(), news.await())
    }
}*/



fun getConfigFromApi(callback: (config: String) -> Unit) {
    val conf =  "Config";
    callback(conf)
}

fun getConfigFromApi(): String {
    return "Config"
}


fun runOnUiThread(function: () -> Unit) {
    TODO("Not yet implemented")
}

fun getNewsFromApi(): List<News> {

    return listOf(News("news1", "10/12/2023"), News("news2", "11/12/2023"))
}

fun getNewsFromApi(config: String): List<News> {

    return listOf(News("news1", "10/12/2023"), News("news2", "11/12/2023"))
}

fun getNewsFromApi(callback: (input: List<News>) -> Unit) {
    val news = listOf(News("news1", "10/12/2023"), News("news2", "11/12/2023"))
    callback(news)
}

fun getNewsFromApi(config: String, callback: (input: List<News>) -> Unit) {
    val news = listOf(News("news1", "10/12/2023"), News("news2", "11/12/2023"))
    callback(news)
}

fun getUserFromApi(): String {
    return "User1"
}

fun getUserFromApi(callback: (user: String) -> Unit) {
    val user = "User1"
    callback(user)
}

data class News(val title: String, val publishedAt: String) {

}

class View {
    fun showNews(sortedNews: List<News>) {
        TODO("Not yet implemented")
    }

    fun showNews(user: String, sortedNews: List<News>) {
        TODO("Not yet implemented")
    }
}

class ViewModelScope(){
    fun launch(function: () -> Unit) {
        TODO("Not yet implemented")
    }

}
