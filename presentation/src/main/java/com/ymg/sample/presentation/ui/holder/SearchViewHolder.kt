package com.ymg.sample.presentation.ui.holder

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ymg.sample.domain.entity.Media
import com.ymg.sample.presentation.databinding.FragmentSearchItemBinding
import kotlinx.coroutines.flow.MutableSharedFlow



class SearchViewHolder (
    view: View,
    private val clickItemEvent: MutableSharedFlow<Media>
) : RecyclerView.ViewHolder(view) {

    val binding: FragmentSearchItemBinding = DataBindingUtil.bind(view) ?: throw IllegalStateException()

    fun bind(data: Media?) {
        data?.let {
            bindThumbnailView(it)
            bindVideoIcon(it)
        }
    }



    /**
     * 이미지
     *
     * @param data
     */
    private fun bindThumbnailView(data: Media) {
        with(binding.thumbnailView) {
            setOnClickListener {
                clickItemEvent.tryEmit(data)
            }
        }
    }

    /**
     * 동영상 아이콘
     *
     * @param data
     */
    private fun bindVideoIcon(data: Media) {
        with(binding.videoIcon) {
            visibility = if (data.type == Media.TYPE_VIDEO) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }
    }
}