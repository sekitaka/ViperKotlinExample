package me.sekitaka.viper.module.articles.contract

import me.sekitaka.viper.entity.Article

interface Presenter {
    fun onViewCreate()
    fun onArticleClicked(article: Article)
    fun onArticlesFetched(articles: Array<Article>)
}

interface Interactor {
    var output: InteractorOutput
    fun fetchArticles()
}

interface InteractorOutput {
    fun articlesFetched(articles: Array<Article>)
}

interface View {
    fun showArticles(articles: Array<Article>)
}

interface Router {
    fun unregister()
    fun presentArticleDetailScreen(article: Article)
}