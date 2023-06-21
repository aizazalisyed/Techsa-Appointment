package java.com.techsaappointment

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AppointmentDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
   suspend fun addAppointment(appointmentModel: AppointmentModel)

   @Query("SELECT * FROM appointment_table WHERE status = 'New Appointment'")
   fun readAllNewAppointment(): LiveData<List<AppointmentModel>>
}