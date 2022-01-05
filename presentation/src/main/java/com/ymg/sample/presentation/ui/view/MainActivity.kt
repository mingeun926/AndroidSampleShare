package com.ymg.sample.presentation.ui.view

import com.google.android.material.tabs.TabLayoutMediator
import com.jakewharton.rxbinding4.widget.textChanges
import com.ymg.sample.presentation.R
import com.ymg.sample.presentation.BR
import com.ymg.sample.presentation.base.BaseActivity
import com.ymg.sample.presentation.databinding.ActivityMainBinding
import com.ymg.sample.presentation.extention.addDisposable
import com.ymg.sample.presentation.extention.errorToast
import com.ymg.sample.presentation.extention.toast
import com.ymg.sample.presentation.ui.adapter.MainViewPagerAdapter
import com.ymg.sample.presentation.ui.viewmodel.MainViewModel
import com.ymg.sample.presentation.ui.viewstate.MainState
import com.ymg.sample.presentation.util.event.EventObserver
import kotlinx.coroutines.flow.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.concurrent.TimeUnit



class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    private val mainViewModel: MainViewModel by viewModel()



    override fun getLayoutResourceId(): Int = R.layout.activity_main

    override fun getBindingVariable(): Int = BR.viewModel

    override fun getViewModel(): MainViewModel = mainViewModel

    override fun init() {
        initView()
        observe()
    }



    /**
     * Init View
     */
    private fun initView() {
        with(binding) {
            // ViewPager
            viewPager.adapter = MainViewPagerAdapter(this@MainActivity)
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                when (position) {
                    0 -> {
                        tab.text = getString(R.string.tab_text_search)
                    }

                    else -> {
                        tab.text = getString(R.string.tab_text_storage)
                    }
                }
            }.attach()

            // 검색
            editSearch.textChanges()
                .debounce(1000, TimeUnit.MILLISECONDS)
                .map {
                    it.toString()
                }
                .subscribe {
                    if (it.trim().isEmpty()) {
                        mainViewModel.clearSearch()
                    } else {
                        mainViewModel.search(it)
                    }
                }
                .addDisposable(mainViewModel.disposable)
        }
    }

    /**
     * Observer
     */
    private fun observe() {
        // Main State Observer
        mainViewModel.mainState.observe(this, EventObserver {
            when (it) {
                MainState.SUCCESS_SAVE_DATA -> {
                    toast(getString(R.string.toast_success_save_data))
                }

                MainState.SUCCESS_REMOVE_DATA -> {
                    toast(getString(R.string.toast_success_remove_data))
                }

                else -> Unit
            }
        })

        // Exception Observer
        mainViewModel.exceptionError.observe(this, EventObserver {
            errorToast(it)
        })
    }
}