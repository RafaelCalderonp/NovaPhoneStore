package com.example.novaphonestore.model

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.novaphonestore.model.local.PhoneNovaDao
import com.example.novaphonestore.model.local.entities.PhoneDetailsEntity
import com.example.novaphonestore.model.remote.RetrofitClient

class PhoneNovaRepository (private val phoneDao: PhoneNovaDao){

    private val networkService = RetrofitClient.retrofitInstance()
    val phoneListLiveData = phoneDao.getAllPhone()

    suspend fun fetchPhone(){
        val service = kotlin.runCatching { networkService.fetchPhoneList() }
        service.onSuccess {
            when(it.code()){
                200 -> it.body()?.let {
                    phoneDao.insertAllPhone(fromInternetToPhoneEntity(it))
                }
                else -> Log.d("REPO","${it.code()} - ${it.errorBody()}")
            }
        }
        service.onFailure {
            Log.e("REPO","${it.message}")
        }
    }

    suspend fun fetchPhoneDetails(id: Int) {
        val service = kotlin.runCatching { networkService.fetchPhoneDetails(id) }
        service.onSuccess {
            when(it.code()){
                200 -> it.body()?.let {
                    phoneDao.insertPhoneDetail(fromInternetToPhoneDetailsEntity(it))
                }
            }
        }
    }

    fun getPhoneDetailsByID(id: Int) : LiveData<PhoneDetailsEntity>{
        return phoneDao.getPhoneDetailsByID(id)
    }


}