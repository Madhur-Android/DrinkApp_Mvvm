package com.example.drink.views

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.drink.MyRepository
import com.example.drink.R
import com.example.drink.adapter.HomeAdapter
import com.example.drink.model.Drink
import com.example.drink.retrofit.ApiService
import com.example.drink.viewModel.MyViewModel
import com.example.drink.viewModel.MyViewModelFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var user_rv : RecyclerView
    private lateinit var viewModel: MyViewModel
    private lateinit var homeAdapter: HomeAdapter
    private lateinit var search_box: EditText
    private lateinit var enter_btn: ImageButton
    private lateinit var progress_bar: ProgressBar

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        user_rv = findViewById(R.id.rv_product)
        search_box = findViewById(R.id.search_box)
        enter_btn = findViewById(R.id.enter_btn)
        progress_bar = findViewById(R.id.progress_bar)

        user_rv.layoutManager = GridLayoutManager(this, 2)

        homeAdapter = HomeAdapter(emptyList(),this )

        val apiService = Retrofit.Builder()
            .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

        val repository = MyRepository(apiService)
        viewModel = ViewModelProvider(this, MyViewModelFactory(repository))
            .get(MyViewModel::class.java)

        viewModel.userData.observe(this) {Response ->
            progress_bar.visibility = View.GONE
            val list: List<Drink> = Response ?: emptyList()
            homeAdapter = HomeAdapter(list,this )
            user_rv.adapter = homeAdapter
        }

        viewModel.error.observe(this) { error ->
            Log.e("MainActivity", "Error: $error")
        }

        viewModel.fetchData(s = "all")

        enter_btn.setOnClickListener(View.OnClickListener {
            val search = search_box.text.toString()
            viewModel.fetchData(s = search)
        })
    }
}