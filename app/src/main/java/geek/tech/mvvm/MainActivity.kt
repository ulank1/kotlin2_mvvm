package geek.tech.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.async
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    val viewModel:MainViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.messageLiveData.observe(this, Observer {
            message.text = it
        })

        viewModel.getQuiz(10)

        send.setOnClickListener {
            if (edit_message.text.toString().isNotEmpty()){
                viewModel.setMessage(edit_message.text.toString())
                edit_message.setText("")
            }else{
                edit_message.error = "Enter Message"
            }
        }

    }

}