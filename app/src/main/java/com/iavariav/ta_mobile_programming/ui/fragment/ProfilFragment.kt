package com.iavariav.ta_mobile_programming.ui.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import com.iavariav.ta_mobile_programming.R
import com.iavariav.ta_mobile_programming.helper.Config
import com.iavariav.ta_mobile_programming.model.DataDiriModel
import com.iavariav.ta_mobile_programming.model.DataItem
import com.iavariav.ta_mobile_programming.presenter.ProfilPresenter
import kotlinx.android.synthetic.main.fragment_profil.*
import kotlinx.android.synthetic.main.fragment_profil.view.*

/**
 * A simple [Fragment] subclass.
 *
 */
class ProfilFragment : Fragment() {
    private lateinit var profilPresenter: ProfilPresenter
    private var dataDiriModel: ArrayList<DataItem> = arrayListOf()

    private lateinit var npm:String
    private lateinit var key:String
    private var jenisKelamin: String = ""

    private lateinit var npmTexView: TextView
    private lateinit var nik: TextView
    private lateinit var nisn: TextView
    private lateinit var nama: TextView
    private lateinit var tahun_masuk: TextView
    private lateinit var tgl_msk: TextView
    private lateinit var kelamin: TextView
    private lateinit var transpor: TextView
    private lateinit var dosen_wali: TextView
    private lateinit var kelas: TextView
    private lateinit var ktlhr: TextView
    private lateinit var tlhr: TextView
    private lateinit var agama: TextView
    private lateinit var almt: TextView
    private lateinit var rt: TextView
    private lateinit var rw: TextView
    private lateinit var dusun: TextView
    private lateinit var kec: TextView
    private lateinit var prop: TextView
    private lateinit var telp: TextView
    private lateinit var foto: ImageView
    private lateinit var kalmt: TextView
    private lateinit var kpos: TextView
    private lateinit var email: TextView
    private lateinit var nmortu: TextView
    private lateinit var darah: TextView
    private lateinit var alamat_kos: TextView
    private lateinit var ayah: TextView
    private lateinit var ibu: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_profil, container, false)
        npmTexView = view.tvNpm
        nik = view.tvNik
        nisn = view.tvNISN
        nama = view.tvNama
        tahun_masuk = view.tvTahunMasuk
        tgl_msk = view.tvTanggalMasuk
        kelamin = view.tvJenisKelamin
        transpor = view.tvTransportasi
        dosen_wali = view.tvDosenWali
        kelas = view.tvKelas
        ktlhr = view.tvTanggalLahir
        tlhr = view.tvTempatLahir
        agama = view.tvAgama
        almt = view.tvAlamat
        rt = view.tvRtRw
//        rw = view.tvIbu
        dusun = view.tvDusun
        kec = view.tvKecamatan
        prop = view.tvKodeProfinsi
        telp = view.tvTelepon
        foto = view.ivImageProfile
//        kalmt = view.tvk
        kpos = view.tvKodePos
        email = view.tvEmail
//        nmortu = view.tv
        darah = view.tvGolonganDarah
        alamat_kos = view.tvAlamatKos
        ayah = view.tvAyah
        ibu = view.tvIbu




        npm = activity?.intent!!.getStringExtra(Config.BUNDLE_NPM)
        key = activity?.intent!!.getStringExtra(Config.BUNDLE_KEY)
        npmTexView.text = npm
//        Toast.makeText(activity, "" + npm + key , Toast.LENGTH_LONG).show()
        profilPresenter = ProfilPresenter(dataDiriModel, activity!!, jenisKelamin)
        profilPresenter.getProfil(key, npm, nik, nisn, nama, tahun_masuk, tgl_msk, kelamin, transpor, dosen_wali, kelas, ktlhr, tlhr,
            agama, alamat_kos, rt, dusun, kec, prop, telp, foto, kpos, email, darah, alamat_kos, ayah, ibu)
        return view;
    }


}
