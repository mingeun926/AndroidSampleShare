package com.ymg.sample.presentation.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.ymg.sample.presentation.R



class ProgressWrapper @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle) {
    init {
        View.inflate(context, R.layout.wrapper_progress, this)
    }
}