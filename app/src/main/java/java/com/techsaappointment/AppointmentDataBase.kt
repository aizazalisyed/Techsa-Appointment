package java.com.techsaappointment

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [AppointmentModel::class], version = 1)
abstract class AppointmentDataBase : RoomDatabase(){

    abstract fun appointmentDao (): AppointmentDao

    companion object{
        @Volatile
        private var INSTANCE: AppointmentDataBase? = null

        fun getDataBase(context: Context) : AppointmentDataBase{
            val temInstance = INSTANCE
            if(temInstance != null){
                return temInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppointmentDataBase::class.java,
                    "database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }


}