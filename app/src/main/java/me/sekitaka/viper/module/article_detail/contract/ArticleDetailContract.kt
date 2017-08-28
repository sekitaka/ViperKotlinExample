package me.sekitaka.viper.module.article_detail.contract

import android.content.Intent
import me.sekitaka.viper.entity.Article


interface Presenter {
    fun onViewCreate(intent: Intent)
}

interface View {
    fun showArticleDetail(article: Article)
}

interface Router {
    fun unregister()
}

