package com.ymg.sample.presentation.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ymg.sample.presentation.ui.view.SearchFragment
import com.ymg.sample.presentation.ui.view.StorageFragment



class MainViewPagerAdapter (
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                SearchFragment.newInstance()
            }

            else -> {
                StorageFragment.newInstance()
            }
        }
    }
}