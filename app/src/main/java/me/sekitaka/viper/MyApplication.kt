package me.sekitaka.viper

import android.app.Application
import android.util.Log
import io.realm.Realm
import me.sekitaka.viper.entity.Article
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class MyApplication : Application(), AnkoLogger {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        setupData()
    }

    fun setupData() {
        var realm = Realm.getDefaultInstance()
        val articles = realm.where(Article::class.java).findAll()
        if (articles.count() > 0) {
            return
        }
        info { "Setup Initial Data" }
        realm.executeTransaction {
            var article: Article?
            for (id in 1..20) {
                article = realm.createObject(Article::class.java, id)
                article.title = "title ${id}"
                article.body = "body ${id}"
            }
        }
    }
}