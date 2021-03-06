package com.example.novaphonestore.model.local.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.novaphonestore.model.local.PhoneNovaDao
import com.example.novaphonestore.model.local.entities.PhoneDetailsEntity
import com.example.novaphonestore.model.local.entities.PhoneEntity

@Database(entities = [PhoneEntity::class, PhoneDetailsEntity::class], version = 1, exportSchema = false)
abstract class PhoneDataBase : RoomDatabase() {

    abstract fun getPhoneNovaDao() :PhoneNovaDao

    companion object{
        @Volatile
        private var
                INSTANCE : PhoneDataBase? = null
        fun getDataBase(context: Context) : PhoneDataBase{
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PhoneDataBase::class.java, "phone_db")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}