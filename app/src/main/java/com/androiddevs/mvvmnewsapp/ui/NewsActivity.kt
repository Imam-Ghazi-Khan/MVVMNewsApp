package com.androiddevs.mvvmnewsapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.androiddevs.mvvmnewsapp.R
import com.androiddevs.mvvmnewsapp.db.ArticleDatabase
import com.androiddevs.mvvmnewsapp.repositories.NewsRepository
import kotlinx.android.synthetic.main.activity_news.bottomNavigationView
import kotlinx.android.synthetic.main.activity_news.newsNavHostFragment
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class NewsActivity : AppCompatActivity() {

    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelFactory = NewsViewModelFactory(newsRepository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(NewsViewModel::class.java)
        bottomNavigationView.setupWithNavController(newsNavHostFragment.findNavController())
    }
}
