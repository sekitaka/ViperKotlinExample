package me.sekitaka.viper.module.article_detail.presenter

import android.content.Intent
import me.sekitaka.viper.entity.Article
import me.sekitaka.viper.module.article_detail.contract.Presenter
import me.sekitaka.viper.module.article_detail.view.ArticleDetailActivity
import org.jetbrains.anko.AnkoLogger
import org.parceler.Parcels

class ArticleDetailPresenter(var view : ArticleDetailActivity) : Presenter, AnkoLogger {
    override fun onViewCreate(intent: Intent) {
        var article = Parcels.unwrap<Article>(intent.getParcelableExtra("Article"))
        view.showArticleDetail(article)
    }

}
