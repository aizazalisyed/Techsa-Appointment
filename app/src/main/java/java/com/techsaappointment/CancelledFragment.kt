package java.com.techsaappointment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class CancelledFragment : Fragment() {


    private lateinit var appointmentModelArray: Array<AppointmentModel>
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cancelled, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewCancelled)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        initialize()

        val recyclerViewAdapter = RecyclerViewAdapter(requireContext(), appointmentModelArray)
        recyclerView.adapter = recyclerViewAdapter
        recyclerViewAdapter.notifyDataSetChanged()
    }

    private fun initialize() {

        appointmentModelArray = arrayOf(
            AppointmentModel(1, "Cancelled", "Dr Aizaz Ali", "Abdul Majid", "12/6/23"),
            AppointmentModel(2, "Cancelled", "Dr Ahmed Raza", "Abdul Majid", "12/6/23"),
            AppointmentModel(3, "Cancelled", "Dr Haneef", "Abdul Majid", "12/6/23"),
            AppointmentModel(4, "Cancelled", "Dr Ijaz Ahmed", "Abdul Majid", "12/6/23"),
            AppointmentModel(5, "Cancelled", "Dr Muzamil", "Abdul Majid", "12/6/23"),
            AppointmentModel(6, "Cancelled", "Dr Hassan", "Abdul Majid", "12/6/23"),
            AppointmentModel(7, "Cancelled", "Dr Ifran Hameed", "Abdul Majid", "12/6/23"),
            AppointmentModel(7, "Cancelled", "Dr Iqrar", "Abdul Majid", "12/6/23"),
            AppointmentModel(9, "Cancelled", "Dr Mushtaq", "Abdul Majid", "12/6/23"),
            AppointmentModel(10, "Cancelled", "Dr Youfus", "Abdul Majid", "12/6/23")
        )

    }
}