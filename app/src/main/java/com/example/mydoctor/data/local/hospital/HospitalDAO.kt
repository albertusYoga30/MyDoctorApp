package com.example.mydoctor.data.local.hospital

import androidx.room.*
import com.example.mydoctor.data.local.hospital.HospitalCache

@Dao
interface HospitalDAO {

    @Query("SELECT * FROM Hospital")
    suspend fun getAllHospital():List<HospitalCache>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllHospital(vararg  hospitals: HospitalCache)

    @Delete
    suspend fun deleteHospital(hospital: HospitalCache)

    @Update
    suspend fun updateHospital(hospital: HospitalCache)

}