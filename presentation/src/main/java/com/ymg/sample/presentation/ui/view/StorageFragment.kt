package com.ymg.sample.presentation.ui.view

import androidx.lifecycle.asLiveData
import com.ymg.sample.presentation.R
import com.ymg.sample.presentation.BR
import com.ymg.sample.presentation.base.BaseFragment
import com.ymg.sample.presentation.databinding.FragmentStorageBinding
import com.ymg.sample.presentation.extention.alert
import com.ymg.sample.presentation.ui.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel



class StorageFragment : BaseFragment<FragmentStorageBinding, MainViewModel>() {

    companion object {
        fun newInstance() = StorageFragment()
    }

    private val mainViewModel: MainViewModel by sharedViewModel()



    override fun getLayoutResourceId(): Int = R.layout.fragment_storage

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
        mainViewModel.storageAdapter.clickItemEvent.asLiveData().observe(this, {
            requireContext().alert(
                getString(R.string.alert_inquiry_remove_data),
                { _, _ ->
                    mainViewModel.removeItem(it)
                },
                null
            )
        })
    }
}