package com.mykuniran.core.network

import okhttp3.Interceptor
import okhttp3.Response

class SupabaseAuthInterceptor(
    private val sessionManager: SessionManager
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val token = sessionManager.getAccessToken() ?: SupabaseConfig.anonKey

        val requestBuilder = originalRequest.newBuilder()
            .header("apikey", SupabaseConfig.anonKey)
            .header("Authorization", "Bearer $token")
            .header("Content-Type", "application/json")
            .header("Accept", "application/json")

        return chain.proceed(requestBuilder.build())
    }
}
