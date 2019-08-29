package com.iavariav.ta_mobile_programming.presenter

import android.annotation.SuppressLint
import android.support.v4.app.FragmentActivity
import android.view.View
import android.widget.*
import com.bumptech.glide.Glide
import com.iavariav.ta_mobile_programming.R
import com.iavariav.ta_mobile_programming.model.DataItem
import com.iavariav.ta_mobile_programming.rest.ApiService
import com.iavariav.ta_mobile_programming.rest.RetroConfig
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class ProfilPresenter(
    private var items: ArrayList<DataItem> = arrayListOf(),
    private val context: FragmentActivity, var jenisKelamin: String
) {
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
        ibu: TextView,
        div: LinearLayout,
        sv: ScrollView
    ) {
        val apiService: ApiService = RetroConfig.provideApi()
        apiService.getProfil(key, npm)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                items.clear()
                if (it.error.equals("1")){
                    div.visibility = View.VISIBLE
                    sv.visibility = View.GONE
                } else{
                    div.visibility = View.GONE
                    sv.visibility = View.VISIBLE
                    items = it.data as ArrayList<DataItem>
                    for (i: Int in items.indices) {
                        nik.text = items.get(i).nik
                        nisn.text = items.get(i).nisn
                        nama.text = items.get(i).nama
                        tahun_masuk.text = items.get(i).tahunMasuk
                        tgl_msk.text = items.get(i).tglMsk
                        jenisKelamin = items.get(i).kelamin
                        if (jenisKelamin.equals("1")) {
                            jenisKelamin = "Laki - laki"
                        } else {
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
                        Glide.with(context).load("http://informatika.upgris.ac.id/mobile/image/" + items.get(i).foto)
                            .override(512, 512).error(R.drawable.error_image).into(foto)
                        kpos.text = items.get(i).kpos
                        email.text = items.get(i).email
                        darah.text = items.get(i).darah
                        alamat_kos.text = items.get(i).alamatKos
                        ayah.text = items.get(i).ayah
                        ibu.text = items.get(i).ibu

                        if (npm.equals("16670025")) {
                            ayah.text = "Kepo"
                            ibu.text = "Kepo"
                            nik.text = "Kepo"
                            nisn.text = "Kepo"
                            tlhr.text = "Kepo"
                            dusun.text = "Kepo"
                            alamat_kos.text = "Kepo"
                            kelamin.text = "Rahasia"
                            darah.text = "ABC"
                            Glide.with(context).load("https://avatars0.githubusercontent.com/u/28645602?s=460&v=4")
                                .override(512, 512).error(R.drawable.error_image).into(foto)

                        }
                    }

                }


            }, {
                error("Error" + it.message)
            })
    }
}

