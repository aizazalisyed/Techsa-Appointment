package java.com.techsaappointment

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.VideoView
import java.lang.Thread.sleep
import java.net.URI

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val icon : TextView = findViewById(R.id.techsaIcon)
        icon.alpha = 0f
        icon.animate().setDuration(3000).alpha(1f).withEndAction{

            sleep(1000)
            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }

    }
}