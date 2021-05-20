package trinidad.daniel.bioxotic.ui.Global_chat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class Global_char_View_Model {
    private val _text = MutableLiveData<String>().apply {
        value = "This is contact Fragment"
    }
    val text: LiveData<String> = _text
}