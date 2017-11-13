package me.sekitaka.viper

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import me.sekitaka.viper.module.articles.view.ArticlesActivity
import org.jetbrains.anko.startActivity

class LaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity<ArticlesActivity>()
        finish()
    }
}
