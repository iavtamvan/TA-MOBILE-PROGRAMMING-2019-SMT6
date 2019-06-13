package com.iavariav.ta_mobile_programming.presenter

import android.annotation.SuppressLint
import android.support.v4.app.FragmentActivity
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.iavariav.ta_mobile_programming.R
import com.iavariav.ta_mobile_programming.model.DataItem
import com.iavariav.ta_mobile_programming.rest.ApiService
import com.iavariav.ta_mobile_programming.rest.RetroConfig
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class ProfilPresenter(
    private var items: ArrayList<DataItem> = arrayListOf(),
    private val context: FragmentActivity, var jenisKelamin: String) {
    @SuppressLint("SetTextI18n")
    fun getProfil(
        key: String,
        npm: String,
        nik: TextView,
        nisn: TextView,
        nama: TextView,
        tahun_masuk: TextView,
        tgl_msk: TextView,
        kelamin: TextView,
        transpor: TextView,
        dosen_wali: TextView,
        kelas: TextView,
        ktlhr: TextView,
        tlhr: TextView,
        agama: TextView,
        almt: TextView,
        rtDanRw: TextView,
        dusun: TextView,
        kec: TextView,
        prop: TextView,
        telp: TextView,
        foto: ImageView,
        kpos: TextView,
        email: TextView,
        darah: TextView,
        alamat_kos: TextView,
        ayah: TextView,
        ibu: TextView
    ) {
        val apiService: ApiService = RetroConfig.provideApi()
        apiService.getProfil(key, npm)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                items.clear()
                items = it.data as ArrayList<DataItem>
                for (i:Int in items.indices){
//                    nik = items.get(i).nik!!
//                    nisn = items.get(i).nisn
//                    nama = items.get(i).nama
//                    tahun_masuk = items.get(i).tahunMasuk
//                    tgl_msk = items.get(i).tglMsk
//                    kelamin = items.get(i).kelamin
//                    transpor = items.get(i).transpor
//                    dosen_wali = items.get(i).dosenWali
//                    kelas = items.get(i).kelas
//                    ktlhr = items.get(i).ktlhr
//                    tlhr = items.get(i).tlhr
//                    agama = items.get(i).agama
//                    almt = items.get(i).almt
//                    rtDanRw = items.get(i).rtDanRw
//                    rw = items.get(i).rw
//                    dusun = items.get(i).dusun
//                    kec = items.get(i).kec
//                    prop = items.get(i).prop
//                    telp = items.get(i).telp
//                    foto = items.get(i).foto
//                    kalmt = items.get(i).kalmt
//                    kpos = items.get(i).kpos
//                    email = items.get(i).email
//                    nmortu = items.get(i).nmortu
//                    darah = items.get(i).darah
//                    alamat_kos = items.get(i).alamatKos
//                    ayah = items.get(i).ayah
//                    ibu = items.get(i).ibu
                    nik.text = items.get(i).nik
                    nisn.text = items.get(i).nisn
                    nama.text = items.get(i).nama
                    tahun_masuk.text = items.get(i).tahunMasuk
                    tgl_msk.text = items.get(i).tglMsk
                    jenisKelamin = items.get(i).kelamin
                    if (jenisKelamin.equals("1")){
                        jenisKelamin = "Laki - laki"
                    } else{
                        jenisKelamin = "Perempuan"
                    }
                    kelamin.text = jenisKelamin
                    transpor.text = items.get(i).transpor
                    dosen_wali.text = items.get(i).dosenWali
                    kelas.text = items.get(i).kelas
                    ktlhr.text = items.get(i).ktlhr
                    tlhr.text = items.get(i).tlhr
                    agama.text = items.get(i).agama
                    almt.text = items.get(i).almt
                    rtDanRw.text = items.get(i).rt + "/" + items.get(i).rw
                    dusun.text = items.get(i).dusun
                    kec.text = items.get(i).kec
                    prop.text = items.get(i).prop
                    telp.text = items.get(i).telp
                    Glide.with(context).load("http://informatika.upgris.ac.id/mobile/image/" + items.get(i).foto).override(512, 512).error(R.drawable.error_image).into(foto)
                    kpos.text = items.get(i).kpos
                    email.text = items.get(i).email
                    darah.text = items.get(i).darah
                    alamat_kos.text = items.get(i).alamatKos
                    ayah.text = items.get(i).ayah
                    ibu.text = items.get(i).ibu
                }
            }, {
                error("Error" + it.message)
            })
    }
}

