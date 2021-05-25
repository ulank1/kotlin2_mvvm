package geek.tech.mvvm.data.repository

import geek.tech.mvvm.data.api.QuizApi
import geek.tech.mvvm.data.api.model.Quiz
import kotlinx.coroutines.delay
import retrofit2.Response
import kotlin.coroutines.suspendCoroutine

class MainRepo(private val api:QuizApi) {

     suspend fun sendMessage(message:String):String{


        return message
    }

    suspend fun getQuiz(amount:Int):Response<Any>?{
        return try {
            api.getQuiz(amount)
        }catch (e:Exception){
            e.printStackTrace()
            null
        }
    }


}