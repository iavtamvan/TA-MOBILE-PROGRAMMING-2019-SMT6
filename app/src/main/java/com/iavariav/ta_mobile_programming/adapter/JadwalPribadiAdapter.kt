package com.iavariav.ta_mobile_programming.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iavariav.ta_mobile_programming.R
import com.iavariav.ta_mobile_programming.helper.Config
import com.iavariav.ta_mobile_programming.model.DataItem
import com.iavariav.ta_mobile_programming.ui.activity.DataActivity
import com.iavariav.ta_mobile_programming.ui.activity.DetailJadwalActivity
import kotlinx.android.synthetic.main.list_jadwal_kuliah.view.*

class JadwalPribadiAdapter(val dataItem: ArrayList<DataItem>, val context: FragmentActivity?) :
    RecyclerView.Adapter<JadwalPribadiAdapter.ViewHolder>() {
    var namaHari: String? = null
    var namaHariServer: String? = null

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
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
        if (namaHariServer!!.equals("1")) {
            namaHari = "Senin"
        } else if (namaHariServer!!.equals("2")) {
            namaHari = "Selasa"
        } else if (namaHariServer!!.equals("3")) {
            namaHari = "Rabu"
        } else if (namaHariServer!!.equals("4")) {
            namaHari = "Kamis"
        } else if (namaHariServer!!.equals("5")) {
            namaHari = "Jum'at"
        } else if (namaHariServer!!.equals("6")) {
            namaHari = "Sabtu"
        } else if (namaHariServer!!.equals("7")) {
            namaHari = "Minggu"
        }
        viewHolder.listNamaHariJadwal.text = namaHari + ", " + dataItem.get(i).waktu + ", " + dataItem.get(i).nama_ruang
        viewHolder.cvKlik.setOnClickListener {
            //            Toast.makeText(context, "Semangat", Toast.LENGTH_LONG).show()
            val intent = Intent(context, DetailJadwalActivity::class.java)
            intent.putExtra(Config.BUNDLE_KODE_JADWAL, dataItem.get(i).kode_jadwal)
            intent.putExtra(Config.BUNDLE_KODE_KELAS, dataItem.get(i).kode_kelas)
            intent.putExtra(Config.BUNDLE_KODE_MK, dataItem.get(i).kode_mk)
            intent.putExtra(Config.BUNDLE_NAMA_DOSEN, dataItem.get(i).nama_dosen)
            intent.putExtra(Config.BUNDLE_KODE_DOSEN1, dataItem.get(i).kode_dosen1)
            intent.putExtra(Config.BUNDLE_KODE_DOSEN2, dataItem.get(i).kode_dosen2)
            intent.putExtra(Config.BUNDLE_SKS1, dataItem.get(i).sks1)
            intent.putExtra(Config.BUNDLE_NAMA_RUANG, dataItem.get(i).nama_ruang)
            intent.putExtra(Config.BUNDLE_HARI, namaHari)
            intent.putExtra(Config.BUNDLE_WAKTU, dataItem.get(i).waktu)
            intent.putExtra(Config.BUNDLE_NAMA_MK, dataItem.get(i).nama_mk)
            intent.putExtra(Config.BUNDLE_NAMA_MKI, dataItem.get(i).nama_mki)
            context?.startActivity(intent)
        }
    }
}