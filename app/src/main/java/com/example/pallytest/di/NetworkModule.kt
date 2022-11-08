package com.example.pallytest.di

import com.example.pallytest.remote.api.PallyApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

class NetworkModule {

    @Module
    @InstallIn(SingletonComponent::class)
    class NetworkModule {

        @Provides
        @Singleton
        fun gson(): Gson {
            return GsonBuilder()
                .setLenient()
                .serializeNulls()
                .create()
        }

        @Provides
        @Singleton
        fun provideHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
            return OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.MINUTES)
                .build()
        }

        @Provides
        @Singleton
        fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
            return HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            }
        }

        @Provides
        @Singleton
        fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }

        @Provides
        @Singleton
        fun provideAPI(retrofit: Retrofit): PallyApi {
            return retrofit.create(PallyApi::class.java)
        }

        companion object {
            private const val CONNECT_TIMEOUT = 30L
            private const val BASE_URL = "https://letsfeelz.com/tangoapp_backend/public/api/"
        }
    }
}