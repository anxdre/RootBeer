package anxdre.my.id

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import anxdre.my.id.databinding.FragmentMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlin.random.Random

class MainFragment : Fragment(R.layout.fragment_main) {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private var score = 1
    private var highScore = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var answer = generateEssay()

        binding.btnStart.setOnClickListener {
            try {
                val playerAnswer = Integer.parseInt(binding.etPlayerName.editText?.text.toString())
                if (answer == playerAnswer) {
                    score++
                    Snackbar.make(binding.root, "Anda benar poin +1", Snackbar.LENGTH_SHORT).show()
                } else {
                    score--
                    Snackbar.make(binding.root, "Anda salah poin -1", Snackbar.LENGTH_SHORT).show()
                }
            } catch (E: Exception) {
                Toast.makeText(requireContext(), "Harus Inputan Angka", Toast.LENGTH_SHORT).show()
                score--
            } finally {
                answer = generateEssay()
                binding.tvPoint.text = "Point player : $score"

                if (highScore < score) highScore = score

                if (score <= 0) {
                    findNavController().navigate(
                        R.id.actionToGameFragment,
                        bundleOf(Pair("highScore", highScore.toString()))
                    )
                }
            }
        }
    }

    private fun generateEssay(): Int {
        val a = Random.nextInt(0, 9)
        val b = Random.nextInt(0, 9)
        binding.tvEssay.text = "$a + $b"

        return a + b
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}