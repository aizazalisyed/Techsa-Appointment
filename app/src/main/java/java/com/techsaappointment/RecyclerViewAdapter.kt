package java.com.techsaappointment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter (val context: Context, val arrModel: Array<AppointmentModel>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>()
{


    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

        var referenceCodeTextView = itemView.findViewById<TextView>(R.id.referenceCodeTextView)!!
        var statusTextView = itemView.findViewById<TextView>(R.id.statusTextView)!!
        var doctorName = itemView.findViewById<TextView>(R.id.doctorName)!!
        var patientName = itemView.findViewById<TextView>(R.id.patientName)!!
        var relativeLayout = itemView.findViewById<RelativeLayout>(R.id.relativeLayout)!!
        var icon = itemView.findViewById<ImageView>(R.id.icon)!!
        var date = itemView.findViewById<TextView>(R.id.date)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_view_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model : AppointmentModel = arrModel[position]

        holder.referenceCodeTextView.text = "Ref#: " + model.id.toString()
        holder.statusTextView.text = model.status
        holder.patientName.text = model.PatientName
        holder.doctorName.text = model.docName
        holder.date.text = model.date

        when(model.status){

            "New Appointment" -> {
                holder.icon.setImageResource(R.drawable.latest)
                holder.icon.setColorFilter(ContextCompat.getColor(context, R.color.white))
                holder.statusTextView.text = model.status
            }
            "Completed" -> {
                holder.icon.setImageResource(R.drawable.completed)
                holder.icon.setColorFilter(ContextCompat.getColor(context, R.color.white))
                holder.statusTextView.text = model.status
            }
            "Cancelled" -> {
                holder.icon.setImageResource(R.drawable.canclled)
                holder.icon.setColorFilter(ContextCompat.getColor(context, R.color.white))
                holder.statusTextView.text = model.status
            }
        }


    }

    override fun getItemCount(): Int {
       return arrModel.size
    }
}