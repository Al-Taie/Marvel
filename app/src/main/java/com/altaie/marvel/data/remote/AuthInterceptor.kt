package com.altaie.marvel.data.remote

import com.altaie.marvel.BuildConfig
import com.altaie.marvel.utils.toMD5
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val timestamp = System.currentTimeMillis().toString()
        val hash = "$timestamp${BuildConfig.KEY}".toMD5()

        with(chain.request()) {
            url.newBuilder().apply {
                addQueryParameter(API_KEY, BuildConfig.API_KEY)
                addQueryParameter(HASH, hash)
                addQueryParameter(TIMESTAMP, timestamp)
            }.build().also { url ->  return chain.proceed(newBuilder().url(url).build()) }
        }
    }

    companion object {
        const val API_KEY = "apikey"
        const val HASH = "hash"
        const val TIMESTAMP = "ts"
    }
}
