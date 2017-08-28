package me.sekitaka.viper.module.articles.interactor

import io.realm.Realm
import io.realm.RealmResults
import me.sekitaka.viper.entity.Article
import me.sekitaka.viper.module.articles.contract.Interactor
import me.sekitaka.viper.module.articles.contract.InteractorOutput

class ArticlesInteractor(override var output: InteractorOutput) : Interactor {
    val realm = Realm.getDefaultInstance()
    override fun fetchArticles() {
        // maybe async
        val articles = realm.where(Article::class.java).findAll()
        output.articlesFetched(articles.toTypedArray())
    }
}