package java.com.techsaappointment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CompletedFragment : Fragment() {


    private lateinit var appointmentModelArray: Array<AppointmentModel>
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_completed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewCompleted)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        initialize()

        val recyclerViewAdapter = RecyclerViewAdapter(requireContext(), appointmentModelArray)
        recyclerView.adapter = recyclerViewAdapter
        recyclerViewAdapter.notifyDataSetChanged()
    }

    private fun initialize() {

        appointmentModelArray = arrayOf(
            AppointmentModel(1, "Completed", "Dr Aizaz Ali", "Abdul Majid", "12/6/23"),
            AppointmentModel(2, "Completed", "Dr Ahmed Raza", "Abdul Majid", "12/6/23"),
            AppointmentModel(3, "Completed", "Dr Haneef", "Abdul Majid", "12/6/23"),
            AppointmentModel(4, "Completed", "Dr Ijaz Ahmed", "Abdul Majid", "12/6/23"),
            AppointmentModel(5, "Completed", "Dr Muzamil", "Abdul Majid", "12/6/23"),
            AppointmentModel(6, "Completed", "Dr Hassan", "Abdul Majid", "12/6/23"),
            AppointmentModel(7, "Completed", "Dr Ifran Hameed", "Abdul Majid", "12/6/23"),
            AppointmentModel(7, "Completed", "Dr Iqrar", "Abdul Majid", "12/6/23"),
            AppointmentModel(9, "Completed", "Dr Mushtaq", "Abdul Majid", "12/6/23"),
            AppointmentModel(10, "Completed", "Dr Youfus", "Abdul Majid", "12/6/23")
        )

    }
}