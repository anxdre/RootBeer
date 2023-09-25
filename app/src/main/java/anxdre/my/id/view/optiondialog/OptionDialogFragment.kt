package anxdre.my.id.view.optiondialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import anxdre.my.id.R
import anxdre.my.id.databinding.FragmentOptionDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class OptionDialogFragment : BottomSheetDialogFragment(R.layout.fragment_option_dialog) {
    private var _binding: FragmentOptionDialogBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOptionDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listOfLevel = arrayOf("Easy", "Medium", "Hard", "Impossible")
        val adapter = ArrayAdapter<String>(
            requireContext(),
            android.R.layout.simple_dropdown_item_1line,
            listOfLevel
        )
        binding.etLevel.setAdapter(adapter)
    }
}