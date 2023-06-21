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

class RecyclerViewAdapterNew(val context: Context) : RecyclerView.Adapter<RecyclerViewAdapterNew.ViewHolder>()
{


    private var newAppointmentList = emptyList<AppointmentModel>()

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
        val model : AppointmentModel = newAppointmentList[position]

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
                holder.statusTextView.setTextColor(ContextCompat.getColor(context, R.color.mintgreen));
                holder.relativeLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.mintgreen))
            }
            "Completed" -> {
                holder.icon.setImageResource(R.drawable.completed)
                holder.icon.setColorFilter(ContextCompat.getColor(context, R.color.white))
                holder.statusTextView.text = model.status
                holder.statusTextView.setTextColor(ContextCompat.getColor(context, R.color.periwinkle));
                holder.relativeLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.periwinkle))
            }
            "Cancelled" -> {
                holder.icon.setImageResource(R.drawable.canclled)
                holder.icon.setColorFilter(ContextCompat.getColor(context, R.color.white))
                holder.statusTextView.text = model.status
                holder.statusTextView.setTextColor(ContextCompat.getColor(context, R.color.peachpuff));
                holder.relativeLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.peachpuff))
            }
        }


    }

    override fun getItemCount(): Int {
       return newAppointmentList.size
    }

    fun setData(newAppointmentList: List<AppointmentModel>){
        this.newAppointmentList = newAppointmentList
        notifyDataSetChanged()
    }
}