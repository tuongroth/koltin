package com.vilover.project2252.Activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.uilover.project2252.databinding.ActivitySplashBinding
import com.uilover.project22522.MainActivity
import com.vilover.project2252.databinding.ActivitySplashBinding
import com.vilover.project2252.Activity.MainActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Optional: Enables edge-to-edge content
        WindowCompat.setDecorFitsSystemWindows(window, false)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Splash screen delay (2 seconds)
        Handler(Looper.getMainLooper()).postDelayed({
            // Navigate to MainActivity (or LoginActivity)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 2000) // 2000 milliseconds = 2 seconds
    }
}
