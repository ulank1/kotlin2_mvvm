package geek.tech.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import geek.tech.mvvm.data.repository.MainRepo
import kotlinx.coroutines.launch

class MainViewModel(private val repo:MainRepo):ViewModel() {
    private val _messageLiveData:MutableLiveData<String> = MutableLiveData()
    val messageLiveData:LiveData<String> = _messageLiveData

    fun setMessage(message:String){
        viewModelScope.launch {
            _messageLiveData.value = repo.sendMessage(message)
        }
    }

}