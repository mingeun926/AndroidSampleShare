package com.ymg.sample.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment



abstract class BaseFragment<B: ViewDataBinding, VM: BaseViewModel> : Fragment() {

    private var _binding: B? = null
    protected val binding get() = _binding ?: throw IllegalStateException()



    @LayoutRes
    abstract fun getLayoutResourceId(): Int

    abstract fun getBindingVariable(): Int
    abstract fun getViewModel(): VM

    abstract fun init()



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return DataBindingUtil.inflate<B>(inflater, getLayoutResourceId(), container, false).also {
            _binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            setVariable(getBindingVariable(), getViewModel())
        }

        init()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}