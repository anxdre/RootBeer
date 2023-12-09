package anxdre.my.id.view.studentlist

import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import anxdre.my.id.R
import anxdre.my.id.data.model.Student
import kotlin.random.Random

class StudentListViewModel : ViewModel() {
    val studentLiveData = MutableLiveData<List<Student>>(listOf())
    val studentLoadErrorLiveData = MutableLiveData<Boolean>()
    val loadingLiveData = MutableLiveData<Boolean>()

    fun refresh(){
        var listTemp = arrayListOf<Student>()
        for (i in 0..10){
            listTemp.add(Student("16042012$i","mahasiswa $i","20-08-0$i","0851569647${Random(i).nextInt(0,9)}","https://picsum.photos/id/${Random(i).nextInt(3,100)}/300"))

        }
        studentLiveData.value = listTemp
        studentLoadErrorLiveData.value = false
        loadingLiveData.value = false
    }
}