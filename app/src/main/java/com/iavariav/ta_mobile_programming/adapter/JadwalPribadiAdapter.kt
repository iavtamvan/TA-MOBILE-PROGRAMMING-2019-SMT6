package com.iavariav.ta_mobile_programming.adapter

import android.annotation.SuppressLint
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.iavariav.ta_mobile_programming.R
import com.iavariav.ta_mobile_programming.model.DataItem
import kotlinx.android.synthetic.main.list_jadwal_kuliah.view.*

class JadwalPribadiAdapter (val dataItem: ArrayList<DataItem>, val context: FragmentActivity?):
    RecyclerView.Adapter<JadwalPribadiAdapter.ViewHolder>() {
    var namaHari:String? = null
    var namaHariServer:String? = null
    class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val listNamaMatakuliahDosenJadwal = view.listNamaMatakuliahDosenJadwal
        val listNamaDosenJadwal = view.listNamaDosenJadwal
        val listNamaHariJadwal = view.listNamaHariJadwal
        val cvKlik = view.cvKlik
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): JadwalPribadiAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_jadwal_kuliah, p0, false))


    }

    override fun getItemCount(): Int {
        return dataItem.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(viewHolder: JadwalPribadiAdapter.ViewHolder, i: Int) {
        viewHolder.listNamaDosenJadwal.text = dataItem.get(i).nama_dosen
        viewHolder.listNamaMatakuliahDosenJadwal.text = dataItem.get(i).nama_mk
        namaHariServer = dataItem.get(i).hari
        if (namaHariServer!!.equals("1")){
            namaHari = "Senin"
        } else if (namaHariServer!!.equals("2")){
            namaHari = "Selasa"
        }
        else if (namaHariServer!!.equals("3")){
            namaHari = "Rabu"
        }
        else if (namaHariServer!!.equals("4")){
            namaHari = "Kamis"
        }
        else if (namaHariServer!!.equals("5")){
            namaHari = "Jum'at"
        }
        else if (namaHariServer!!.equals("6")){
            namaHari = "Sabtu"
        }
        else if (namaHariServer!!.equals("7")){
            namaHari = "Minggu"
        }
        viewHolder.listNamaHariJadwal.text = namaHari+ ", " + dataItem.get(i).waktu + ", " + dataItem.get(i).nama_ruang
        viewHolder.cvKlik.setOnClickListener {
            Toast.makeText(context, "Semangat", Toast.LENGTH_LONG).show()
        }
    }
}