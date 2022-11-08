package com.example.pallytest.interceptor

import com.example.pallytest.common.PreferenceHelper
import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor constructor(private val preferenceHelper: PreferenceHelper) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val newRequest = chain.request().newBuilder().apply {

            if (!(preferenceHelper.token.isNullOrEmpty())) {
                addHeader(AUTHORIZATION, BEARER + preferenceHelper.token)
            }

            addHeader(ACCEPT, APP_JSON)

        }.build()

        return chain.proceed(newRequest)
    }

    companion object {
        const val BEARER = "Bearer "
        const val ACCEPT = "Accept"
        const val APP_JSON = "application/json"
        const val AUTHORIZATION = "Authorization"
    }
}