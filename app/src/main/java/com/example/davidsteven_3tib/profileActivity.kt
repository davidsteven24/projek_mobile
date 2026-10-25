package com.example.davidsteven_3tib

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.davidsteven_3tib.databinding.ActivityProfileBinding

class profileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    private lateinit var sessionManager: SessionManager // Deklarasi SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inisialisasi SessionManager
        sessionManager = SessionManager(this)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnLogout.setOnClickListener {
            // 1. Ubah status login di SharedPreferences menjadi false
            sessionManager.setLogin(false)

            // 2. Pindah kembali ke LoginActivity dan hapus tumpukan activity sebelumnya
            val intent = Intent(this, LoginActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            startActivity(intent)
            finish()
        }


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
            val intent = Intent(this, unggahFragment::class.java) // Sesuaikan dengan Activity/Fragment tujuan Anda
            startActivity(intent)
        }

        // 4. Navigasi ke Halaman Favorit
        binding.navFavorit.setOnClickListener {
            val intent = Intent(this, favoriteActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}