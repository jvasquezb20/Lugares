package com.lugare_v.repository

import androidx.lifecycle.LiveData
import androidx.room.*
import com.lugare_v.data.LugarDao
import com.lugare_v.model.Lugar


class LugarRepository(private val lugarDao: LugarDao) {
    suspend fun addLugar(lugar: Lugar){
        lugarDao.addLugar( lugar)
    }

    suspend fun updateLugar(lugar: Lugar){
        lugarDao.updateLugar(lugar)
    }

    suspend fun deleteLugar(lugar: Lugar){
        lugarDao.deleteLugar(lugar)
    }

    fun getLugares() : LiveData<List<Lugar>> = lugarDao.getLugares()




}