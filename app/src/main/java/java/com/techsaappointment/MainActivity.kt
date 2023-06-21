package java.com.techsaappointment

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager2: ViewPager2
    private lateinit var adapter: FragmentPageAdapter
    private lateinit var toolbar: Toolbar
    private lateinit var floatingActionButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tabLayout)
        viewPager2 = findViewById(R.id.viewPager2)
        toolbar = findViewById(R.id.toolbar)
        floatingActionButton = findViewById(R.id.floatingActionButton)

        setSupportActionBar(toolbar)
        adapter = FragmentPageAdapter(supportFragmentManager, lifecycle)

        supportActionBar?.apply {
            title = "Techsa Appointment"
        }
        toolbar.setTitleTextColor(ContextCompat.getColor(this@MainActivity, android.R.color.white))


        tabLayout.addTab(tabLayout.newTab().setText("New"))
        tabLayout.addTab(tabLayout.newTab().setText("Completed"))
        tabLayout.addTab(tabLayout.newTab().setText("Cancelled"))

        viewPager2.adapter = adapter

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    viewPager2.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabLayout.selectTab(tabLayout.getTabAt(position))

            }
        })

        floatingActionButton.setOnClickListener {
            showCustomDialog()
        }

    }

    private fun getCurrentDate(): String {
        val dateFormat = SimpleDateFormat("dd/MM/yy", Locale.getDefault())
        val currentDate = Date()
        return dateFormat.format(currentDate)
    }

    private fun showCustomDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val view = LayoutInflater.from(this).inflate(R.layout.add_appointment_dialogbox, null)
        dialog.setContentView(view)

        val cancelButton: TextView = view.findViewById(R.id.cancleTextView)
        val doneButton: TextView = view.findViewById(R.id.doneButton)
        val patientNameEditText: EditText = view.findViewById(R.id.patientNameEditText)
        val doctorNameEditText: EditText = view.findViewById(R.id.doctorNameEditText)

        cancelButton.setOnClickListener {
            dialog.dismiss()
        }

        doneButton.setOnClickListener {
            val patientName = patientNameEditText.text.toString()
            val doctorName = doctorNameEditText.text.toString()
            val currentDate = getCurrentDate()

           //todo

            dialog.dismiss()
        }

        dialog.show()
    }
}