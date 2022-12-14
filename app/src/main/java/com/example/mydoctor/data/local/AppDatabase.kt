package com.example.mydoctor.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mydoctor.data.local.hospital.HospitalCache
import com.example.mydoctor.data.local.hospital.HospitalDAO

@Database(version = 1, exportSchema = false, entities = [HospitalCache::class])
abstract class AppDatabase : RoomDatabase() {

    abstract fun hospitalDAO():HospitalDAO

    companion object {
        private var instance: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "myDoctor"
                ).build()
            }
            return instance!!
        }
    }
}