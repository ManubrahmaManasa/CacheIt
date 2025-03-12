package com.example.cacheit

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cacheit.data.Repository
import com.example.cacheit.databinding.ActivityMainBinding
import com.example.cacheit.presentation.MyAdapter
import com.example.cacheit.presentation.MyViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    private lateinit var adapter: MyAdapter

    private val viewModel: MyViewModel by viewModels { MyViewModelFactory(application) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = MyAdapter(emptyList())
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        binding.recyclerview.adapter = adapter

        //CallBack Approach API Calling
        /*viewModel.items.observe(this) { items ->
            adapter.updateData(items)
        }*/


        viewModel.fetchPosts()

        lifecycleScope.launch {
            viewModel.data.observe(this@MainActivity) {items ->
                adapter.updateData(items)
            }
        }
        /*viewModel.fetchPosts()

        viewModel.data.observe(this){items->
            adapter.updateData(items)
        }*/



    }
}