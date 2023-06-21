package java.com.techsaappointment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {

    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        button = findViewById(R.id.loginButton)

        button.setOnClickListener(){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}