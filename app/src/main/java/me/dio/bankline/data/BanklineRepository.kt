package me.dio.bankline.data

import android.util.Log
import androidx.lifecycle.liveData
import me.dio.bankline.data.remote.BanklineApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BanklineRepository {
    private val Tag = javaClass.simpleName


    private val restApi by lazy {
        return@lazy Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/")

            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BanklineApi::class.java)
    }


    fun findBankStatement(accountHolderId: Int) = liveData {
        emit(State.Wait)
        try {
            emit(State.Success(data = restApi.findBankStatement(accountHolderId)))
        } catch (e: Exception) {
            Log.e(Tag, e.message, e)
            emit(State.Error(e.message))
        }
    }
}

