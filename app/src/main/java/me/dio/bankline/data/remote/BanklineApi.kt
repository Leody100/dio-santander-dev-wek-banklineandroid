package me.dio.bankline.data.remote

import android.accounts.Account
import android.security.identity.AccessControlProfileId
import me.dio.bankline.domain.Movimentacao
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path

interface BanklineApi {

    @GET("movimentacoes/{id}")
   suspend fun  findBankStatement(@Path("id") accountHolderId: Int):List<Movimentacao>


}