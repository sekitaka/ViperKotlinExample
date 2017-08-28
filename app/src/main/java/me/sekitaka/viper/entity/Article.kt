package me.sekitaka.viper.entity

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import org.parceler.Parcel


@RealmClass
@Parcel(value = Parcel.Serialization.BEAN, analyze = arrayOf(Article::class))
open class Article : RealmObject() {
    @PrimaryKey var key: Long = 0
    var title: String? = null
    var body: String? = null
}
