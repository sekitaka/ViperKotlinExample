package me.sekitaka.viper.module.article_detail.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import android.widget.TextView
import me.sekitaka.viper.R
import me.sekitaka.viper.entity.Article
import me.sekitaka.viper.module.article_detail.presenter.ArticleDetailPresenter
import org.jetbrains.anko.*
import org.parceler.Parcels

//import kotlinx.android.synthetic.main.

class ArticleDetailActivity : AppCompatActivity(), me.sekitaka.viper.module.article_detail.contract.View, AnkoLogger {
    var presenter = ArticleDetailPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ArticleDetailActivityUI().setContentView(this)
        presenter.onViewCreate(intent)
    }

    override fun showArticleDetail(article: Article) {
        var title = find<TextView>(R.id.title_text_view)
        var body = find<TextView>(R.id.body_text_view)
        title.text = article.title
        body.text = article.body
    }

}

class ArticleDetailActivityUI : AnkoComponent<ArticleDetailActivity> {
    override fun createView(ui: AnkoContext<ArticleDetailActivity>) = with(ui) {
        linearLayout {
            orientation = LinearLayout.VERTICAL
            textView {
                id = R.id.title_text_view
                text = "TITLE"
                textSize = 24f
            }
            textView {
                id = R.id.body_text_view
                text = "BODY"
                textSize = 16f
            }
        }
    }
}
