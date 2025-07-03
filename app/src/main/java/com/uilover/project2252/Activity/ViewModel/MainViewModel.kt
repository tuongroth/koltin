package com.uilover.project2252.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.uilover.project2252.Activity.Domain.BannerModel
import com.uilover.project2252.Activity.Repository.MainRespository


class MainViewModel : ViewModel() {

    private val repository =MainRespository()

    fun loadBanner(): LiveData<MutableList<BannerModel>> {
        return repository.loadBanner()
    }
}
