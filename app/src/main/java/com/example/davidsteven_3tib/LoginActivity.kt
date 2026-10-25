package com.example.davidsteven_3tib

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.davidsteven_3tib.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var sessionManager: SessionManager // Deklarasi SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sessionManager = SessionManager(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnlogin.setOnClickListener {
            val user = binding.edtUsername.text.toString().trim()
            val pass = binding.edtpassword.text.toString().trim()

            // 1. Validasi input tidak boleh kosong
            if (user.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Username dan Password tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (user == "dave" && pass == "12345") {
                sessionManager.setLogin(true)

                Log.e("hasil", "Login Berhasil - username $user")
                Toast.makeText(this, "Login Berhasil!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java).apply {
                    putExtra("username", user)
                    putExtra("password", pass)
                    putExtra("umur", 30)
                }
                startActivity(intent)
                finish() // Tutup LoginActivity agar tidak bisa kembali dengan tombol back
            } else {
                // Jika login gagal
                Toast.makeText(this, "Username atau Password salah!", Toast.LENGTH_LONG).show()
            }
        }
    }
}