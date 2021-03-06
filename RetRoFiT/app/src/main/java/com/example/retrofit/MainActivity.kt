package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit.adapter.MyAdapter
import com.example.retrofit.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row_layout.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)

        viewModel.myResponse.observe(this, {
            Log.d("tag", it.toString())
            val adapter = MyAdapter(it)
            recyclerview.layoutManager = LinearLayoutManager(this)
            recyclerview.adapter = adapter
            adapter.notifyDataSetChanged()
        }).also { viewModel.getPost() }

    }
}