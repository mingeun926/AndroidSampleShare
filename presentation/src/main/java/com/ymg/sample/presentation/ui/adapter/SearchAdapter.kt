package com.ymg.sample.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.ymg.sample.domain.entity.Media
import com.ymg.sample.presentation.R
import com.ymg.sample.presentation.ui.holder.SearchViewHolder
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow



class SearchAdapter : ListAdapter<Media, SearchViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Media>() {
            override fun areItemsTheSame(
                oldItem: Media,
                newItem: Media
            ): Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: Media,
                newItem: Media
            ): Boolean = oldItem == newItem
        }
    }

    private val _clickItemEvent: MutableSharedFlow<Media> =
        MutableSharedFlow(
            replay = 0,
            extraBufferCapacity = 1,
            onBufferOverflow = BufferOverflow.DROP_OLDEST
        )
    val clickItemEvent: SharedFlow<Media>
        get() = _clickItemEvent.asSharedFlow()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.fragment_search_item,
                parent,
                false
            ),
            _clickItemEvent
        )
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        getItem(position)?.run {
            holder.binding.data = this
            holder.bind(this)
            holder.binding.executePendingBindings()
        }
    }



    fun clear() {
        submitList(listOf())
    }
}