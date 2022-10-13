package com.lugare_v.repository

import androidx.lifecycle.LiveData
import androidx.room.*
import com.lugare_v.data.LugarDao
import com.lugare_v.model.Lugar


class LugarRepository(private val lugarDao: LugarDao) {
    suspend fun saveLugar(lugar: Lugar){
        if(lugar.id==0){ //se inserta
        lugarDao.addLugar( lugar)
    }else{ //el lugar se actualiza
            lugarDao.updateLugar(lugar)
    }
    }

    suspend fun deleteLugar(lugar: Lugar){
        lugarDao.deleteLugar(lugar)
    }

    fun getLugares() : LiveData<List<Lugar>> = lugarDao.getLugares()




}