package com.learning.c23kotlincoroutinelibrary

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

val articleRepository= ArticleRepository()
val userService= UserService()




suspend fun getArticlesForUser(
    userToken: String?,
): List<ArticleJson> = coroutineScope {
    val articles = async { articleRepository.getArticles() }
    val user = userService.getUser(userToken)
    articles.await()
        .filter { canSeeOnList(user, it) }
        .map { toArticleJson(it) }
}



class ArticleJson(article: Article) {

}

class Article(val name: String){

}

class ArticleRepository {
    fun getArticles(): List<Article> {
        return listOf(Article("A1"), Article("A2"), Article("A3"))
    }

}

class UserService {
    fun getUser(userToken: String?): User {
        return User()
    }

}

class User {

}

fun toArticleJson(it: Article): ArticleJson {
    return ArticleJson(it)
}


fun canSeeOnList(user: User, it: Article): Boolean {
    return true
}
