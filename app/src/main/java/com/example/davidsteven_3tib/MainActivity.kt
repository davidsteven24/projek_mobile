package com.example.davidsteven_3tib

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.davidsteven_3tib.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Menerima data dari Intent sebelumnya jika ada
        val user = intent.getStringExtra("username")
        val pass = intent.getStringExtra("password")
        val umur = intent.getIntExtra("umur", 0)

        Log.e("hasil", "user: $user, umur $umur")

        // ==========================================
        // LOGIKA NAVIGASI BAWAH (BOTTOM NAVIGATION)
        // ==========================================

        // 1. Tombol Home (Sudah di MainActivity, jadi dibiarkan atau opsional)
        // binding.navHome.setOnClickListener { ... }

        // 2. Navigasi ke Halaman Jelajahi
        binding.navJelajahi.setOnClickListener {
            val intent = Intent(this, jelajahiActivity::class.java)
            startActivity(intent)
            finish() // Opsional: tutup activity lama agar tidak menumpuk di memori
        }

        // 3. Tombol Unggah (+)
        binding.navUnggah.setOnClickListener {
            // Aksi ketika tombol unggah ditekan, contoh memindahkan ke Fragment Unggah atau Activity Unggah
            val intent = Intent(this, unggahFragment::class.java) // Sesuaikan dengan tujuan Anda
            startActivity(intent)
        }

        // 4. Navigasi ke Halaman Favorit
        binding.navFavorit.setOnClickListener {
            val intent = Intent(this, favoriteActivity::class.java)
            startActivity(intent)
            finish()
        }

        // 5. Navigasi ke Halaman Profil
        binding.navProfil.setOnClickListener {
            val intent = Intent(this, profileActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}