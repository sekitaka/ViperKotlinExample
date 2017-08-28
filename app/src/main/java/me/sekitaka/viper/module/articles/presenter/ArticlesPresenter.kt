package me.sekitaka.viper.module.articles.presenter

import me.sekitaka.viper.entity.Article
import me.sekitaka.viper.module.articles.contract.InteractorOutput
import me.sekitaka.viper.module.articles.contract.Presenter
import me.sekitaka.viper.module.articles.interactor.ArticlesInteractor
import me.sekitaka.viper.module.articles.router.ArticlesRouter
import me.sekitaka.viper.module.articles.view.ArticlesActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class ArticlesPresenter(var view: ArticlesActivity) : Presenter, InteractorOutput, AnkoLogger {
    var interactor: ArticlesInteractor
    var router = ArticlesRouter(view)

    init {
        interactor = ArticlesInteractor(this)
    }

    // InteractorOutput
    override fun articlesFetched(articles: Array<Article>) {
        onArticlesFetched(articles)
    }

    override fun onViewCreate() {
        interactor.fetchArticles()
    }

    override fun onArticleClicked(article: Article) {
        router.presentArticleDetailScreen(article)
    }

    override fun onArticlesFetched(articles: Array<Article>) {
        view.showArticles(articles)
    }

}