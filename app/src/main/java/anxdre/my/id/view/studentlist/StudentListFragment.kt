package anxdre.my.id.view.studentlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import anxdre.my.id.R
import anxdre.my.id.databinding.FragmentStudentDetailBinding

class StudentListFragment:Fragment(R.layout.fragment_student_list) {
    private var _binding:FragmentStudentDetailBinding? = null
    private val binding get()  = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStudentDetailBinding.inflate(inflater,container,false)
        return binding!!.root
    }
}