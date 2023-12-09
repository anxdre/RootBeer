package anxdre.my.id.view.studentdetail

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import anxdre.my.id.R
import anxdre.my.id.data.model.Student
import anxdre.my.id.databinding.FragmentStudentDetailBinding
import anxdre.my.id.util.SetNotification
import kotlin.random.Random

class StudentDetailFragment : Fragment(R.layout.fragment_student_detail), SetNotification {

    private var _binding: FragmentStudentDetailBinding? = null
    private val binding get() = _binding

    private val data by lazy { arguments?.getSerializable("data") as Student }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val data =
        _binding = FragmentStudentDetailBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.student = data
        binding?.parent = this
        binding?.notification = this
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun createNotification(view: View) {
        var builder = NotificationCompat.Builder(requireContext(), "RootBeer")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Student Notification")
            .setContentText(data.name)
            .setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText("Lorem ipsum, Hello i'am ${data.name}")
            )
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        Log.d("notification block", "its running")
        with(NotificationManagerCompat.from(requireContext())) {
            // notificationId is a unique int for each notification that you must define.
            if (ActivityCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                    200
                )
                return
            }
            notify(Random(12).nextInt(), builder.build())
        }

    }

    fun createNotificationFromView(data: Student) {
        var builder = NotificationCompat.Builder(requireContext(), "RootBeer")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Student Notification")
            .setContentText(data.name)
            .setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText("Lorem ipsum, Hello i'am ${data.name}")
            )
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(requireContext())) {
            // notificationId is a unique int for each notification that you must define.
            if (ActivityCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                    200
                )
                return
            }
            notify(Random(12).nextInt(), builder.build())
        }
    }
}