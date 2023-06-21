package java.com.techsaappointment

import android.animation.ObjectAnimator
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.text.SimpleDateFormat
import java.util.*

class NewFragment : Fragment() {

    private lateinit var floatingActionButton: FloatingActionButton
    private lateinit var viewPager: ViewPager2
    private var isFabVisible = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager = requireActivity().findViewById(R.id.viewPager2)

        floatingActionButton = view.findViewById(R.id.floatingActionButton)
        floatingActionButton.setOnClickListener {
            showCustomDialog()
        }

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                if (position != 0) {
                    hideFab()
                } else {
                    showFab()
                }
            }
        })
    }


    private fun showCustomDialog() {
        val dialog = Dialog(context!!)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val view = LayoutInflater.from(context!!).inflate(R.layout.add_appointment_dialogbox, null)
        dialog.setContentView(view)

        val cancelButton: TextView = view.findViewById(R.id.cancleTextView)
        val doneButton: TextView = view.findViewById(R.id.doneButton)
        val patientNameEditText: EditText = view.findViewById(R.id.patientNameEditText)
        val doctorNameEditText: EditText = view.findViewById(R.id.doctorNameEditText)

        cancelButton.setOnClickListener {
            dialog.dismiss()
        }

        doneButton.setOnClickListener {
            val patientName = patientNameEditText.text.toString()
            val doctorName = doctorNameEditText.text.toString()
            val currentDate = getCurrentDate()

            //todo

            dialog.dismiss()
        }

        dialog.show()
    }

    private fun getCurrentDate(): String {
        val dateFormat = SimpleDateFormat("dd/MM/yy", Locale.getDefault())
        val currentDate = Date()
        return dateFormat.format(currentDate)
    }
    private fun hideFab() {
        if (isFabVisible) {
            val animator = ObjectAnimator.ofFloat(
                floatingActionButton,
                "alpha",
                1f,
                0f
            )
            animator.duration = 100
            animator.start()
            isFabVisible = false
        }
    }

    private fun showFab() {
        if (!isFabVisible) {
            val animator = ObjectAnimator.ofFloat(
                floatingActionButton,
                "alpha",
                0f,
                1f
            )
            animator.duration = 2000
            animator.start()
            isFabVisible = true
        }
    }
}