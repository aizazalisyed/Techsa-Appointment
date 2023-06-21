package java.com.techsaappointment

import androidx.lifecycle.LiveData

class Repository(private val appointmentDao: AppointmentDao) {

    val readAllData: LiveData<List<AppointmentModel>> = appointmentDao.readAllData()

    suspend fun addAppointment(appointmentModel: AppointmentModel) {
        appointmentDao.addAppointment(appointmentModel)
    }
}