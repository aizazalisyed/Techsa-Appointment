package java.com.techsaappointment

import androidx.lifecycle.LiveData

class Repository(private val appointmentDao: AppointmentDao) {

    val readAllNewAppointment: LiveData<List<AppointmentModel>> = appointmentDao.readAllNewAppointment()

    suspend fun addAppointment(appointmentModel: AppointmentModel) {
        appointmentDao.addAppointment(appointmentModel)
    }
}