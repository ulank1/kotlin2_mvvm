package geek.tech.mvvm.data.repository

import kotlinx.coroutines.delay
import kotlin.coroutines.suspendCoroutine

class MainRepo {

     suspend fun sendMessage(message:String):String{
        delay(2000)
        return message
    }

}