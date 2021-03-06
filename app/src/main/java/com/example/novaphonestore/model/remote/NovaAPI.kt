package com.example.novaphonestore.model.remote

import com.example.novaphonestore.model.remote.fromInternet.PhoneDetails
import com.example.novaphonestore.model.remote.fromInternet.Phone
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface NovaAPI {
    @GET("products/")
    suspend fun fetchPhoneList(): Response<List<Phone>>

//____________________________________________________________________________

    @GET("details/{id}")
    suspend fun fetchPhoneDetails(@Path("id")id: Int): Response<PhoneDetails>

}