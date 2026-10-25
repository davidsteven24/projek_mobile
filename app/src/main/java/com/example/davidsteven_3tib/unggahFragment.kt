package com.example.davidsteven_3tib

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.example.davidsteven_3tib.databinding.FragmentUnggahBinding

class unggahFragment : Fragment() {

    // Deklarasi variabel View Binding untuk Fragment
    private var _binding: FragmentUnggahBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inisialisasi View Binding
        _binding = FragmentUnggahBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Setup Data untuk Spinner Kategori Genre
        val kategoriList = listOf("Pilih Kategori (misal: Lanskap)", "Lanskap", "Potret", "Jalanan", "Analog", "Arsitektur", "Budaya")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, kategoriList)
        binding.spinnerKategori.adapter = adapter

        // 2. Logika Tombol Ketuk / Unggah Foto
        // (Biasanya menggunakan Activity Result API untuk memilih gambar dari galeri)
        binding.btnUploadFile.setOnClickListener {
            Toast.makeText(requireContext(), "Membuka galeri untuk pilih file...", Toast.LENGTH_SHORT).show()
            // TODO: Tambahkan intent picker galeri di sini jika diperlukan
        }

        // 3. Logika Tombol Publikasikan Karya
        binding.btnPublikasikan.setOnClickListener {
            val judul = binding.edtJudul.text.toString().trim()
            val harga = binding.edtHarga.text.toString().trim()
            val deskripsi = binding.edtDeskripsi.text.toString().trim()
            val kategori = binding.spinnerKategori.selectedItem.toString()

            // Validasi Sederhana
            if (judul.isEmpty()) {
                binding.edtJudul.error = "Judul karya tidak boleh kosong!"
                binding.edtJudul.requestFocus()
                return@setOnClickListener
            }

            if (harga.isEmpty()) {
                binding.edtHarga.error = "Harga wajib diisi!"
                binding.edtHarga.requestFocus()
                return@setOnClickListener
            }

            if (kategori.startsWith("Pilih Kategori")) {
                Toast.makeText(requireContext(), "Silakan pilih kategori genre terlebih dahulu!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Jika validasi sukses, tampilkan pesan sukses (bisa diganti proses simpan ke database/API)
            Snackbar.make(binding.root, "Karya '$judul' berhasil dipublikasikan!", Snackbar.LENGTH_LONG).show()

            // Kosongkan form kembali setelah berhasil
            binding.edtJudul.text.clear()
            binding.edtHarga.text.clear()
            binding.edtDeskripsi.text.clear()
            binding.spinnerKategori.setSelection(0)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Bersihkan binding untuk menghindari memory leak pada fragment
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            unggahFragment().apply {
                arguments = Bundle().apply {
                    putString("param1", param1)
                    putString("param2", param2)
                }
            }
    }
}