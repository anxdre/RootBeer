package anxdre.my.id.view.studentlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import anxdre.my.id.R
import anxdre.my.id.databinding.FragmentStudentDetailBinding
import anxdre.my.id.databinding.FragmentStudentListBinding

class StudentListFragment:Fragment(R.layout.fragment_student_list) {
    private var _binding:FragmentStudentListBinding? = null
    private val binding get()  = _binding

    private val viewModel by lazy { StudentListViewModel() }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStudentListBinding.inflate(inflater,container,false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.rvAdapter = StudentListAdapter(){
            findNavController().navigate(R.id.actionToDetailStudentFragment, bundleOf(Pair("data",it)))
        }
        viewModel.refresh()
        viewModel.studentLiveData.observe(viewLifecycleOwner){
            binding?.rvAdapter?.changeDataSet(it.orEmpty())
        }
    }
}