package geek.tech.mvvm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import geek.tech.mvvm.data.repository.MainRepo
import kotlinx.coroutines.launch
import java.time.temporal.TemporalAmount

class MainViewModel(private val repo:MainRepo):ViewModel() {
    private val _messageLiveData:MutableLiveData<String> = MutableLiveData()
    val messageLiveData:LiveData<String> = _messageLiveData

    fun setMessage(message:String){
        viewModelScope.launch {
            val message = repo.sendMessage(message)
            _messageLiveData.value = message
        }
    }

    fun getQuiz(amount: Int){
        viewModelScope.launch {
            Log.e("QUIZ",repo.getQuiz(amount)!!.body().toString())
        }
    }

}