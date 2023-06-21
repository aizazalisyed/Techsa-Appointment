package java.com.techsaappointment

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "appointment_table")
data class AppointmentModel(

    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var status: String,
    var docName: String,
    var PatientName: String,
    var date: String
)