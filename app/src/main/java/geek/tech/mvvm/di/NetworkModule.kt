package geek.tech.mvvm.di

import geek.tech.mvvm.BuildConfig
import geek.tech.mvvm.data.api.QuizApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val retrofit = createRetrofit()
val QUIZ_API:QuizApi = retrofit.create(QuizApi::class.java)

val networkModule = module {
    single { QUIZ_API }
}

val baseUrl = "https://opentdb.com/"

fun createRetrofit(): Retrofit {
    val r = Retrofit.Builder()
        .baseUrl(baseUrl)
//        .client(getOkHttp())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    return r
}

fun getOkHttp(): OkHttpClient {
    val oc = OkHttpClient.Builder()
        .addInterceptor(getLogInterceptor()).apply{
            setTimeOutToOkHttpClient(this)
        }.build()
    return oc
}

private val sLogLevel =
    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

private fun getLogInterceptor() = HttpLoggingInterceptor().apply { level = sLogLevel }

private fun setTimeOutToOkHttpClient(okHttpClientBuilder: OkHttpClient.Builder) =
    okHttpClientBuilder.apply {
        readTimeout(30L, TimeUnit.SECONDS)
        connectTimeout(30L, TimeUnit.SECONDS)
        writeTimeout(30L, TimeUnit.SECONDS)
    }




