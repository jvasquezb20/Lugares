package com.lugare_v.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.lugare_v.model.Lugar

@Dao
interface LugarDao {

    //CRUD = create read update delete

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addLugar(lugar: Lugar)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateLugar(lugar: Lugar)

    @Delete
    suspend fun deleteLugar(lugar: Lugar)

    @Query ("SELECT * FROM LUGAR")
    fun getLugares() : LiveData<List<Lugar>>


}