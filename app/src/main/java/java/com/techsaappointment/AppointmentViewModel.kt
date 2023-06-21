package java.com.techsaappointment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AppointmentViewModel (application: Application): AndroidViewModel(application){

    private val readAllData: LiveData<List<AppointmentModel>>
    private val repository: Repository

    init{
        val appointmentDao = AppointmentDataBase.getDataBase(application).appointmentDao()
        repository = Repository(appointmentDao)
        readAllData = repository.readAllData
    }

    fun addAppointment(appointmentModel: AppointmentModel){

        viewModelScope.launch (Dispatchers.IO){
            repository.addAppointment(appointmentModel)
        }
    }
}