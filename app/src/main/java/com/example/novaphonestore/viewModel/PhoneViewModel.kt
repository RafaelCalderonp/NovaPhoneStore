package com.example.novaphonestore.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.novaphonestore.model.PhoneNovaRepository
import com.example.novaphonestore.model.local.dataBase.PhoneDataBase
import com.example.novaphonestore.model.local.entities.PhoneDetailsEntity
import com.example.novaphonestore.model.local.entities.PhoneEntity
import kotlinx.coroutines.launch

class PhoneViewModel (application: Application): AndroidViewModel(application){
    private val repository : PhoneNovaRepository

    init {
        val bd = PhoneDataBase.getDataBase(application)
        val phoneDao = bd.getPhoneNovaDao()
        repository = PhoneNovaRepository(phoneDao)
        viewModelScope.launch {
            repository.fetchPhone()
        }
    }

    fun getPhoneList():LiveData<List<PhoneEntity>> = repository.phoneListLiveData

    private var idSelected = -1

    fun getPhoneDetailsByIBFromInternet (id:Int) = viewModelScope.launch {
        idSelected = id
        repository.fetchPhoneDetails(idSelected)
    }

    fun getPhoneDetails() : LiveData<PhoneDetailsEntity> = repository.
        getPhoneDetailsByID(idSelected)

}