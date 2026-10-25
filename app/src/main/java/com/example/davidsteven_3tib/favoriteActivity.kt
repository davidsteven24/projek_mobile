package com.example.davidsteven_3tib

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.davidsteven_3tib.databinding.ActivityFavoriteBinding

class favoriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // ==========================================
        // LOGIKA NAVIGASI BAWAH (BOTTOM NAVIGATION)
        // ==========================================

        // 1. Navigasi ke Halaman Home
        binding.navHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        // 2. Navigasi ke Halaman Jelajahi
        binding.navJelajahi.setOnClickListener {
            val intent = Intent(this, jelajahiActivity::class.java)
            startActivity(intent)
            finish()
        }

        // 3. Tombol Unggah (+)
        binding.navUnggah.setOnClickListener {
            // Aksi ketika tombol unggah ditekan, contoh memindahkan ke Fragment Unggah atau Activity Unggah
            val intent = Intent(this, unggahFragment::class.java) // Sesuaikan dengan tujuan Anda
            startActivity(intent)
        }

        // 4. Tombol Favorit (Sedang berada di favoriteActivity, jadi dikosongkan)
        // binding.navFavorit.setOnClickListener { }

        // 5. Navigasi ke Halaman Profil
        binding.navProfil.setOnClickListener {
            val intent = Intent(this, profileActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}