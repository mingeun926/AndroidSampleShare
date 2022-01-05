package com.ymg.sample.presentation.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding



abstract class BaseActivity<B: ViewDataBinding, VM: BaseViewModel> : AppCompatActivity() {

    protected lateinit var binding: B



    @LayoutRes
    abstract fun getLayoutResourceId(): Int

    abstract fun getBindingVariable(): Int
    abstract fun getViewModel(): VM

    abstract fun init()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, getLayoutResourceId())
        binding.apply {
            lifecycleOwner = this@BaseActivity
            setVariable(getBindingVariable(), getViewModel())
        }

        init()
    }
}