package com.mohamedfathidev.mealscleanarchitecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.mohamedfathidev.domain.util.Constant
import com.mohamedfathidev.domain.util.Constant.TAG
import com.mohamedfathidev.domain.util.Result
import com.mohamedfathidev.domain.util.UiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MealsViewModel by viewModels()
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.list_rv)
        val mealsAdapter = MealsAdapter()

        Log.d(TAG, "app started success")
        viewModel.getMealsData()

        lifecycleScope.launch {
            viewModel.mealsData.collect{ state ->
                when (state) {
                    is UiState.Loading -> Log.d(TAG, "Loading data")
                    is UiState.Success -> mealsAdapter.submitList(state.data)
                    is UiState.Error -> Log.d(TAG, "Error while catching data")
                }
                recyclerView.adapter = mealsAdapter
            }
        }
    }
}