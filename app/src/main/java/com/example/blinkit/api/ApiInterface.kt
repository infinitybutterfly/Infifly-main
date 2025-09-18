package com.example.blinkit.api

import com.example.blinkit.models.CheckStatus
import com.example.blinkit.models.Notification
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiInterface {

    @GET("apis/pg-sandbox/pg/v1/status/{merchantId}/{transactionId}")
    suspend fun checkStatus(
        @HeaderMap header: Boolean,
        @Path("merchantId") merchantId: String,
        @Path("transactionId") transactionId: String
    ): Response<CheckStatus>

    @Headers(
        "Content-Type: application/json",
        "Authorization: Key=<key-enter>"
    )
    @POST("fcm/send")
    fun sendNotification(@Body notification : Notification): Call<Notification>
}