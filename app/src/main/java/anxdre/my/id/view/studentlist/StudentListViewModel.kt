package anxdre.my.id.view.studentlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import anxdre.my.id.data.model.Student

class StudentListViewModel : ViewModel() {
    val studentLiveData = MutableLiveData<MutableList<Student>>()
    val studentLoadErrorLiveData = MutableLiveData<Boolean>()
    val loadingLiveData = MutableLiveData<Boolean>()

    fun refresh(){
        for (i in 0..10){
            studentLiveData.value?.add(Student("$i","mahasiswa $i","20-08-0$i","0851569647$i","url:$i"))
            studentLoadErrorLiveData.value = false
            loadingLiveData.value = false
        }
    }
}