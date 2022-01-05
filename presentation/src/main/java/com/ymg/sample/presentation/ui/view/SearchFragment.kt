package com.ymg.sample.presentation.ui.view

import androidx.lifecycle.asLiveData
import com.ymg.sample.presentation.R
import com.ymg.sample.presentation.BR
import com.ymg.sample.presentation.base.BaseFragment
import com.ymg.sample.presentation.databinding.FragmentSearchBinding
import com.ymg.sample.presentation.extention.alert
import com.ymg.sample.presentation.ui.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel



class SearchFragment : BaseFragment<FragmentSearchBinding, MainViewModel>() {

    companion object {
        fun newInstance() = SearchFragment()
    }

    private val mainViewModel: MainViewModel by sharedViewModel()



    override fun getLayoutResourceId(): Int = R.layout.fragment_search

    override fun getBindingVariable(): Int = BR.viewModel

    override fun getViewModel(): MainViewModel = mainViewModel

    override fun init() {
        observe()
    }



    /**
     * Observer
     */
    private fun observe() {
        // Click Item Event Observer
        mainViewModel.searchAdapter.clickItemEvent.asLiveData().observe(this, {
            requireContext().alert(
                getString(R.string.alert_inquiry_save_data),
                { _, _ ->
                    mainViewModel.addItem(it)
                },
                null
            )
        })
    }
}