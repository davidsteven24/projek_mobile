package com.example.davidsteven_3tib

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.davidsteven_3tib.databinding.ActivityJelajahiBinding

class jelajahiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJelajahiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJelajahiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val daftarKarya = listOf(
            KaryaModel("Tokyo Nights", "Jalanan", "Rp 75.000", R.drawable.boy),
            KaryaModel("Morning Light", "Potret", "Rp 150.000", R.drawable.boy),
            KaryaModel("Tegalalang View", "Lanskap", "Rp 100.000", R.drawable.boy),
            KaryaModel("Gedung Sate", "Arsitektur", "Rp 95.000", R.drawable.boy)
        )

        val adapter = KaryaAdapter(this, daftarKarya)
        binding.listViewKarya.adapter = adapter

        binding.listViewKarya.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = daftarKarya[position]
            Toast.makeText(this, "Memilih: ${selectedItem.judul}", Toast.LENGTH_SHORT).show()
        }

        binding.navHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.navJelajahi.setOnClickListener {
        }

        binding.navUnggah.setOnClickListener {
            Toast.makeText(this, "Menu Unggah", Toast.LENGTH_SHORT).show()
        }

        binding.navFavorit.setOnClickListener {
            val intent = Intent(this, favoriteActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.navProfil.setOnClickListener {
            val intent = Intent(this, profileActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}