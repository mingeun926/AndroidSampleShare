package com.ymg.sample.presentation.ui.databind

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ymg.sample.domain.entity.Media
import com.ymg.sample.presentation.ui.viewmodel.MainViewModel



@BindingAdapter(value = ["searchData", "searchViewModel"])
fun RecyclerView.registerSearchAdapter(
    searchData: List<Media>,
    mainViewModel: MainViewModel
) {
    this.adapter?.let {
        mainViewModel.searchAdapter.submitList(searchData)
    } ?: run {
        adapter = mainViewModel.searchAdapter
    }
}

@BindingAdapter(value = ["storageData", "storageViewModel"])
fun RecyclerView.registerStorageAdapter(
    storageData: List<Media>?,
    mainViewModel: MainViewModel
) {
    this.adapter?.let {
        storageData?.let {
            mainViewModel.storageAdapter.submitList(it)
        }
    } ?: run {
        adapter = mainViewModel.storageAdapter
    }
}
