package com.uilover.project245.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.uilover.project245.Model.BrandModel
import com.uilover.project245.Model.ItemModel
import com.uilover.project245.Model.SliderModel
import com.uilover.project245.Repository.MainRepository

class MainViewModel : ViewModel() {
    private val repository = MainRepository()

    val popular: LiveData<MutableList<ItemModel>> = repository.popular
    val brands: LiveData<MutableList<BrandModel>> = repository.brands
    val banners: LiveData<List<SliderModel>> = repository.banners

    fun loadBrands() = repository.loadBrands()
    fun loadBanners() = repository.loadBanners()
    fun loadPopular() = repository.loadPopular()
}