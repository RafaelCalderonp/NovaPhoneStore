package com.example.novaphonestore.model

import com.example.novaphonestore.model.local.entities.PhoneDetailsEntity
import com.example.novaphonestore.model.local.entities.PhoneEntity
import com.example.novaphonestore.model.remote.fromInternet.Phone
import com.example.novaphonestore.model.remote.fromInternet.PhoneDetails

fun fromInternetToPhoneEntity(phoneList: List<Phone>): List<PhoneEntity> {
    return phoneList.map {
        PhoneEntity(id = it.id, name = it.name, price = it.price, image = it.image)
    }
}


fun fromInternetToPhoneDetailsEntity(phone: PhoneDetails) : PhoneDetailsEntity{
    return PhoneDetailsEntity(id= phone.id, name = phone.name, price = phone.price,
        image = phone.image, description = phone.description, lastPrice = phone.lastPrice,
        credit = phone.credit)
}



