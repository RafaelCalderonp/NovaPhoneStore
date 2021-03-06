package com.example.novaphonestore.model.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.novaphonestore.model.local.entities.PhoneDetailsEntity
import com.example.novaphonestore.model.local.entities.PhoneEntity

@Dao
interface PhoneNovaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE )
    suspend fun insertAllPhone(listPhone: List<PhoneEntity>)

    @Query("SELECT * FROM phone_list_table ORDER BY id ASC")
    fun getAllPhone(): LiveData<List<PhoneEntity>>

//__________________________________________________________________________________________________

    @Insert(onConflict = OnConflictStrategy.REPLACE )
    suspend fun insertPhoneDetail(phone: PhoneDetailsEntity)

    @Query("SELECT * FROM  phone_details_table WHERE id = :id")
    fun getPhoneDetailsByID(id: Int) : LiveData<PhoneDetailsEntity>

}