package me.sekitaka.viper.module.articles.router

import android.app.Activity
import android.content.Intent
import android.os.Parcel
import me.sekitaka.viper.entity.Article
import me.sekitaka.viper.module.article_detail.view.ArticleDetailActivity
import me.sekitaka.viper.module.articles.contract.Router
import org.parceler.Parcels

class ArticlesRouter(var activity: Activity?) : Router {
    override fun unregister() {
        activity = null
    }

    override fun presentArticleDetailScreen(article: Article) {
        val intent = Intent(activity, ArticleDetailActivity::class.java)
        intent.putExtra("Article", Parcels.wrap(Article::class.java, article))
        activity?.startActivity(intent)
    }

}
