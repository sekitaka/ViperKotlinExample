package me.sekitaka.viper.module.articles.view

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import io.realm.Realm

import me.sekitaka.viper.R
import me.sekitaka.viper.entity.Article
import me.sekitaka.viper.module.articles.presenter.ArticlesPresenter
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug
import org.jetbrains.anko.info
import org.jetbrains.anko.warn

import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class ArticlesActivity : AppCompatActivity(), me.sekitaka.viper.module.articles.contract.View, AnkoLogger {
    var presenter = ArticlesPresenter(this)
    var adapter = ArticlesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapter.eventListener = object: ArticlesAdapter.EventListener{
            override fun onClick(article: Article) {
                presenter.onArticleClicked(article)
            }
        }
        ArticlesActivityUI(adapter).setContentView(this)

        presenter.onViewCreate()
    }

    override fun showArticles(articles: Array<Article>) {
        info(articles)
        adapter.articles = articles
        adapter.notifyDataSetChanged()
    }
}

class ArticlesActivityUI(val articlesAdapter: ArticlesAdapter) : AnkoComponent<ArticlesActivity>, AnkoLogger {
    override fun createView(ui: AnkoContext<ArticlesActivity>) = with(ui) {
        frameLayout {
            recyclerView {
                backgroundColor = Color.MAGENTA
                adapter = articlesAdapter
                layoutManager = LinearLayoutManager(context)
            }
        }
    }
}

class ArticleItemUI : AnkoComponent<ViewGroup>, AnkoLogger {
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui) {
            linearLayout {
                backgroundColor = Color.CYAN
                lparams(width = matchParent, height = dip(48))
                orientation = LinearLayout.HORIZONTAL
                var titleTextView = textView {
                    id = R.id.title_text_view
                    textSize = 24f
                }
            }
        }
    }
}

class ArticlesAdapter : RecyclerView.Adapter<ArticlesAdapter.ViewHolder>(), AnkoLogger {
    var articles = arrayOf<Article>()
    var eventListener: EventListener? = null

    override fun getItemCount(): Int {
        info("count:${articles.count()}")
        return articles.count()
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        var article = articles.get(position)
        holder?.titleTextView?.setText(article.title)
        info(article)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        var ankoContext = AnkoContext.create(parent!!.context, parent)
        var holder = ViewHolder(ArticleItemUI().createView(ankoContext))
        holder.itemView.setOnClickListener {
            var article = articles.get(holder.adapterPosition)
            eventListener?.onClick(article)
        }
        return holder
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleTextView: TextView = itemView.find<TextView>(R.id.title_text_view)
    }

    interface EventListener {
        fun onClick(article: Article)
    }
}

