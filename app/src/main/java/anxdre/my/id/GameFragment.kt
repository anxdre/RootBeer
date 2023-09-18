package anxdre.my.id

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import anxdre.my.id.databinding.FragmentGameBinding

class GameFragment : Fragment(R.layout.fragment_game) {
    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val highScore = arguments?.getString("highScore") ?: "0"
        binding.tvHighscore.text = "Your Highscore : $highScore"
        binding.btnPlay.setOnClickListener { findNavController().navigate(R.id.actionToMain) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}