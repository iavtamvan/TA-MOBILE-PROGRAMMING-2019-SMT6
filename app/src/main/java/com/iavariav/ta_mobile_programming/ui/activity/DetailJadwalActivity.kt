package com.iavariav.ta_mobile_programming.ui.activity

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.iavariav.ta_mobile_programming.R
import com.iavariav.ta_mobile_programming.helper.Config
import kotlinx.android.synthetic.main.activity_detail_jadwal.*

class DetailJadwalActivity : AppCompatActivity() {
    private lateinit var kode_jadwal: String
    private lateinit var kode_kelas: String
    private lateinit var kode_mk: String
    private lateinit var nama_dosen: String
    private lateinit var kode_dosen1: String
    private lateinit var kode_dosen2: String
    private lateinit var sks1: String
    private lateinit var nama_ruang: String
    private lateinit var hari: String
    private lateinit var waktu: String
    private lateinit var nama_mk: String
    private lateinit var nama_mki: String
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_jadwal)
        kode_jadwal= intent.getStringExtra(Config.BUNDLE_KODE_JADWAL)
        kode_kelas= intent.getStringExtra(Config.BUNDLE_KODE_KELAS)
        kode_mk= intent.getStringExtra(Config.BUNDLE_KODE_MK)
        nama_dosen= intent.getStringExtra(Config.BUNDLE_NAMA_DOSEN)
        kode_dosen1= intent.getStringExtra(Config.BUNDLE_KODE_DOSEN1)
        kode_dosen2= intent.getStringExtra(Config.BUNDLE_KODE_DOSEN2)
        sks1= intent.getStringExtra(Config.BUNDLE_SKS1)
        nama_ruang= intent.getStringExtra(Config.BUNDLE_NAMA_RUANG)
        hari= intent.getStringExtra(Config.BUNDLE_HARI)
        waktu= intent.getStringExtra(Config.BUNDLE_WAKTU)
        nama_mk= intent.getStringExtra(Config.BUNDLE_NAMA_MK)
        nama_mki= intent.getStringExtra(Config.BUNDLE_NAMA_MKI)

        tvKodeJadwal.text = kode_jadwal
        tvKodeKelas.text = kode_kelas
        tvKodeMataKuliah.text = kode_mk
        tvNamaDosen.text = nama_dosen
        tvKodeDosen.text = kode_dosen1 + ", " + kode_dosen2
        tvSks.text = sks1
        tvNamaRuangan.text = nama_ruang
        tvHari.text = hari
        tvWaktu.text = waktu
        tvNamaMataKuliah.text = nama_mk
        tvNamaMataKuliahEnglish.text = nama_mki
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
