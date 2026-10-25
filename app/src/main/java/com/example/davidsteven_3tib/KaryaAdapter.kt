package com.example.davidsteven_3tib

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class KaryaAdapter(private val context: Context, private val dataSource: List<KaryaModel>) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = convertView ?: inflater.inflate(R.layout.item_karya, parent, false)

        val imgKarya = rowView.findViewById<ImageView>(R.id.imgKarya)
        val txtJudul = rowView.findViewById<TextView>(R.id.txtJudul)
        val txtKategori = rowView.findViewById<TextView>(R.id.txtKategori)
        val txtHarga = rowView.findViewById<TextView>(R.id.txtHarga)

        val karya = getItem(position) as KaryaModel

        imgKarya.setImageResource(karya.gambarRes)
        txtJudul.text = karya.judul
        txtKategori.text = karya.kategori
        txtHarga.text = karya.harga

        return rowView
    }
}